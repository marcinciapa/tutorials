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

## Application Context and Beans

- _ApplicationContext_ (which implements _BeanFactory_) provides basic functionalities for managing beans. During
  injection Spring searches beans in the ApplicationContext. When another component needs the same beans, there is no
  need to create a new instance of the bean again.
- Old versions of Spring required explicit _Autowiring_ (or another form of injecting).
- `SpringApplication.run()` returns the ApplicationContext we can interact with (for example retrieving all available
  beans).
- Available bean scopes:
    - _singleton_ - single bean definition to a single object instance (single bean reused for each injection)
    - _prototype_ - single bean definition to any number of object instances (separate instance for each injection)
    - _request_ - single bean definition to the single HTTP request (only for web-aware ApplicationContext)
    - _session_ - single bean definition to the single HTTP session (only for web-aware ApplicationContext)
    - _global session_ - single bean definition to the single global HTTP session (only for web-aware
      ApplicationContext)
- A scope of a bean can be changed using the combination of `@Bean` and `@Scope` annotations.
- __Bean__ is an object that the Spring Container instantiates, assembles and manages the entire lifecycle for us.
- The name of the bean created from Configuration is the same as the name of a function producing it. To change it, an
  annotation `@Bean("newName")` should be used.

## Error Handling

- In Spring there is a bean which captures an exception and translates it into the error response.
- It's enough to annotate an exception class with `@ResponseStatus` so Spring changes the status code when it's thrown.

