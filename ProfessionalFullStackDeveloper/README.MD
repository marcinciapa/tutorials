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