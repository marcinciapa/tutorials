Codebase for [YouTube course](https://youtu.be/uNB2N_w_ypo?si=IjFJVIPpkGTvKUWU) for Spring Boot and GraphQL

# What I learned

- GraphQL doesn't require API versioning. The structure of the response depends on the client.
- GraphQL queries and types are defined in `schema.graphqls` file.
- In a controller, queries are mapped to methods using `@QueryMapping` annotations. The name of a methods must be the
  same as query name. Arguments must be annotated with `@Argument` annotation.
- In a controller, relations are resolved using `@SchemaMapping` annotated methods. The name of the method must be the
  same as the field name. Argument must be of a parent type.
- To run a test (annotated with `@GraphQlTest`), it's possible to autowire `GraphQlTester`, which acts as a test client.