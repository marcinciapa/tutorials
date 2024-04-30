package com.github.marcinciapa.tutorials.fullstack.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age
) {
}
