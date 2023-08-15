Code for [YouTube course](https://www.youtube.com/watch?v=M0a9WWEA7O0&ab_channel=JavaTechie) for Spring Boot with Jooq tutorial

# Running

Running the application requires local MySQL instance running in Docker:
`docker-compose up -d`

It's also required to run JOOQ generation goal to compile the source code:
`./mvnw jooq-codegen:generate`