Codebase for [YouTube course](https://youtu.be/b9O9NI-RJ3o?si=4Y0eH2iS6FFKR0gd) for Spring Security.

# What I learned

- While Spring Security is applied, Spring Boot automatically delivers `DefaultSecurityFilterChain`, which authorizes
  all requests.
- HTTP code 401 (unauthorized) is returned when authentication fails, 403 (forbidden) is returned when authorization
  fails.
- With `jjwt` library it's easy to create a JWT token containing of username, authorities, signed with signing
  algorithm. Spring Security's UserDetails can be easily mapped to JWT token.