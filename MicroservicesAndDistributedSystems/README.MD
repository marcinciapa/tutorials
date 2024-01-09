Code for [Microservices and Distributed Systems course](https://app.amigoscode.com/p/microservices)

# What I learned

## Bootstrap with Maven

- Maven doesn't resolve the latest version of transitive dependency. The version closer to the root of the dependency
  tree will be used instead. It can be overwritten by specifying the version of dependency directly
  in `<dependencies>` (it moves the dependency closer to the root of the dependency tree).
  Alternatively, `<dependencyManagement>` section could be used to explicitly specify the transitive dependencies'
  versions.
- BOM (Bill of Materials) can be used as a parent POM (Project Object Model) to specify dependencies used in a
  project (`<dependencyManagement>` takes precedence over `<dependencies>` definitions).
- In multimodule Maven project, when root POM should be specified as parent, it's still possible
  to use BOM. Parent POM should include BOM as a `<type>pom</type>` `<scope>import</scope>` dependency. Submodules will
  inherit dependency management and their dependencies will be resolved according to BOM specified in parent
  POM's `<dependencyManagement>` section.

## Your First Microservice

## Microservice Communication via HTTP

- To make use of generated data from Spring Data JPA save, `save()` must be replaced with `saveAndFlush()`.

## Service Discovery with Eureka

- It's easy to start another Spring Boot application on different port by copying the configuration in Intellij and
  providing `--server.port` program argument.

## Open Feign

- Open Feign is a nice way of exposing unified API clients across Spring applications.

## Exercise

## Distributed Tracing

- Trace ID is constant through the entire communication since it's initiated (spans). Span ID is created and constant
  within a single service.
- Sleuth (from Spring Cloud) is a sufficient tool to set traceId and spanId for applications communicating with each
  other.
- Sleuth offers an out-of-the-box integration with Zipkin by adding a single dependency from Spring Cloud.

## Api Gateway With Spring Cloud Gateway

- There are multiple concerns because of which managed load balancers should be used on Production, like: TLS,
  Certificate Management, Authentication, High Availability, Logging, Caching, Path Based Routing etc.
- Load balancers should maintain health checks to determine if the target may accept traffic. Health checks should be
  implemented on application side to check, for example, if the database connection works fine.
- Spring Cloud Gateway allows to quickly spin up a simplified load balancer in Spring ecosystem.
- External traffic should not access services in private network directly. It should be done via a load balancer.