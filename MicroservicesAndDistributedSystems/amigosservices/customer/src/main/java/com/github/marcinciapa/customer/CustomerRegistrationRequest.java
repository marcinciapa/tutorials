package com.github.marcinciapa.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
