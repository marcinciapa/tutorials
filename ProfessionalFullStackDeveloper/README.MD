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

## Databases

- A convenient way to connect to the PostgreSQL running inside the Docker container
  is `docker exec -it bash postgres; psql -U username`.

## Spring Data JPA

- It's possible to define column constraints using `@Column` annotation on field of Entity.
- Interfaces extending `JpaRepository` don't have to be marked as `@Repository`. It's done by default.
- Beans of type `CommandLineRunner` are running when the application starts.

## Get Customer By Id Exercise

## CRUD - Create

- When adding methods to an interface extending `JpaRepository`, Spring Boot Data JPA creates a query based on the
  method name.

## CRUD - Delete (Exercise)

## CRUD - Update (Exercise)

## Datasources, JDBC & Flyway

- `\x` in PostgreSQL enables/disables extended display, which allows displaying records in more user-friendly format.

## Flyway

- In PostgreSQL Big Serial is a numeric data type, which increments automatically, backed by a sequence, which is
  automatically created. When table is created, column has `BIGINT` type.
- Index is automatically created for columns which are included in unique constraint.
- Flyway migrations can be described using SQL files, but also as Java/Spring classes in `db.migration` package.

## JDBC Template

- JDBC Template `queryForObject()` methods invokes `query()` under the hood and throws exception when result set is
  empty.
- Spring Data JPA is suitable for simple domains. For systems requiring extensive SQL queries JDBC is a better choice.

## Testing - Setup

- Using Testcontainers may successfully replace using H2 for testing.
- It's possible to interact with Testcontainers object to extract information about the running container.
- `@DynamicPropertySource` annotation allows to provide properties for Spring, which can override application.yml
  configuration.
- `@SpringBootTest` annotation causes the entire Spring context and application startup.

## Testing JDBC Template

- It's convenient to create and use JdbcTemplate object for testing, after creating DataSource first.
- To test optionals with AssertJ it's convenient to use `assertThat(optional).hasValueSatisfying(...)`.

## Testing JPA Repositories

- `@DataJpaTest` with `@AutoConfigureTestDatabase` allows creating context only with beans necessary to use JPA.
  Without `@AutoConfigureTestDatabase` Spring Test tries to use embedded database.

## DAO Mock Testing

## Testing Business Layer

## Integration testing

- When `@SpringBootTest` annotation is used and configured to start the web server, the client to this web server can be
  obtained by injecting `WebTestClient` object. The port of the web server can be obtained using the `@LocalServerPort`
  annotation.

## The Jar file

## Maven & Tests

- Surefire Maven plugin is used during the 'test' phase to execute the unit tests and generate reports.
- Surefire plugin runs only classes which end with 'Test'. If the test has different naming, tests will not be run
  automatically. It can be configured to exclude classes named `**/*IntegrationTest.java`.
- Spring Boot plugin can be configured to start the Spring application in a specific lifecycle phases.
- After starting the application, Failsafe plugin may be used to run integration tests. The difference between Surefire
  and Failsafe is that Failsafe runs tests in a save mode (fail doesn't stop the execution). It only runs classes which
  end with 'IT', but it can be configured to include classes named `**/*IntegrationTest.java`.
- Spring Boot plugin can be configured to start application for integration tests using a random port. Build helper
  Maven plugin is required for this.
- Spring Boot Maven plugin offers a lot of good features: processing AOT, generating OCI images etc.

## DevOps

- Goals of DevOps: collaboration between development and operations, faster delivery, increased reliability, efficiency
  and const savings.
- DevOps Lifecycle: planning, development, testing, deployment, monitoring.
- Key DevOps practices: Continuous Integration, Continuous Deployment, Infrastructure as Code, Monitoring and Logging
- CI - the practice of regularly merging code changes which is then built and tested automatically.
- CD - Automating software release process - from building and testing to deployment and infrastructure provisioning.

