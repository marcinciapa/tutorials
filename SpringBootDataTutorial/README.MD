Code for [YouTube course](https://www.youtube.com/watch?v=8SGI_XS5OPw&ab_channel=Amigoscode) for Spring Data in Spring
Boot

# Running

Running the application requires local postgres instance running in Docker:
`docker-compose up -d`

Run the class `SpringBootDataTutorialApplication` in IntelliJ

# What I learned

- Spring JPA Data provides a simplified approach for delivering JPA repositories - framework deals with entity manager
  for us providing convenient methods. It's only required to provide an interface extending `JPARepository`.
- Spring Data JPA provides a convenient way to create database schema based on entities. See `application.properties`.
