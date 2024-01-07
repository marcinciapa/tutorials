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

## Exercise

## Distributed Tracing

- Trace ID is constant through the entire communication since it's initiated (spans). Span ID is created and constant
  within a single service.