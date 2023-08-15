Code for [YouTube course](https://www.youtube.com/watch?v=CJjHdchLY9Y&t=594s&ab_channel=Amigoscode) for Spring Boot JDBC and Flyway tutorial

# What I learned
- It's easy to configure different data sources with custom property prefixes in Spring Boot (see DatasourceConfig).
That's a good way to configure a data sources provided from an external library.
- It's enough to have Flyway on the runtime classpath and default migration directory structure for Spring Boot to use it.