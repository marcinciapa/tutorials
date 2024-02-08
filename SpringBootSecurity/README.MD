Codebase for [YouTube course](https://youtu.be/KxqlJblhzfI?si=naZT-aHSRLZ-FdKt) for Spring Boot 3 + Spring Security 6

# What I learned

- When adding `findByX()` method to Spring JPA repository, Spring Data automatically creates a mechanism of finding an
  entity by field X.
- JSON Web Token contains of three parts: Header (type of the token, signing algorithm), Payload (claims: predefined,
  public, custom), Signature (verifies the sender of the token).