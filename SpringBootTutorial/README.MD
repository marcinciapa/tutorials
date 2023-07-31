Code for [YouTube course](https://www.youtube.com/watch?v=9SGDpanrc8U) for Spring Boot

# Running
Running the application requires local postgres instance running in Docker:
`docker-compose up -d`

Run the class `SpringBootTutorialApplication` in IntelliJ

# Test
Using cURL run:
Expected 500:
`curl -X PUT http://localhost:8080/api/v1/student/3 -H 'content-type:application/json' -d '{"name": "Jane S", "email": "js@equino.ovh", "dob": "2004-03-04"}'`
Expected 200:
`curl -X POST http://localhost:8080/api/v1/student -H 'content-type:application/json' -d '{"name": "Jane D", "email": "jd@equino.ovh", "dob": "2004-03-04"}'`
Expected 500:
`curl -X PUT http://localhost:8080/api/v1/student/3 -H 'content-type:application/json' -d '{"name": "Jane S", "email": "js@equino.ovh", "dob": "2004-03-04"}'`
Expected 200:
`curl -X PUT http://localhost:8080/api/v1/student/3 -H 'content-type:application/json' -d '{"name": "Jane S", "email": "jane@equino.ovh", "dob": "2004-03-04"}'`
Expected 200:
`curl -X PUT http://localhost:8080/api/v1/student/3 -H 'content-type:application/json' -d '{"name": "Jane", "email": "jane@equino.ovh", "dob": "2004-03-04"}'`
Expected 200:
`curl -X DELETE http://localhost:8080/api/v1/student/3`

# What I learned
- It's possible to use `@GetMapping` annotation instead of `@RequestMapping(method = GET)`
- `jakarta.persistence.@Transient` annotation tells entity, that it should not be mapped to a database column
- `server.error.include-message=always` in `application.properties` allows sending exception message in error response
