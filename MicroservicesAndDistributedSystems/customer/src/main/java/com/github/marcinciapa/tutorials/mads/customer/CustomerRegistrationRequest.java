package com.github.marcinciapa.tutorials.mads.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
