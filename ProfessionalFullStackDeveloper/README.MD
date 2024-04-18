Code for [Professional Full Stack Developer course](https://www.amigoscode.com/courses/full-stack-professional)

# What I learned

## Project and Environment Setup

- A parent project for Spring Boot application is `org.springframework.boot:spring-boot-starter-parent`. Parent manages
  versions of common dependencies. We can omit versions of any dependency coming from the parent.

## Getting Started with Spring Boot 3

- To run a Spring Boot application it's required to annotate the class with `@SpringBootApplication` and the main method
  should contain: `SpringApplication.run(Main.class, args);`.
- Tomcat is a servlet container, the implementation of Jakarta Servlet.
- Spring Boot application can be configured to run without application server (`spring.main.web-application-type=none`).
- By default, Spring searches bean within the same package where the Main class is.
- _DispatcherServlet_ is a central servlet responsible for handling all requests and redirecting them to appropriate
  controllers.
- Classes annotated with `@RestController` are `@Controller`s, which return serialized JSON response bodies.
- The default serializer for Spring Boot is `com.fasterxml:jackson`.

## HTTP, REST and APIs

- `DELETE` HTTP method is idempotent: no matter if the response code is different from the first call, there is no
  additional side effect.
- `Etag` header in the server's response notifies the client of what is the version of provided resource. Client then
  caches the version and sends it as the `If-None-Match` header next time accessing this resource. If the version
  matches the version of the server, server doesn't have to provide the entire response bode, but just 304 response
  code (Not Modified) informing the client, that what it caches is up-to-date.

## Developer Tools

- XHR stands for _XML HTTP Requests_.
- RestfulTool is an IntelliJ plugin allowing sending HTTP requests from IntelliJ CE.

## CRUD - Read

- To use with Spring JPA, entities cannot be records and fields cannot be final, because the framework has to mutate
  them.

## Structure the Backend