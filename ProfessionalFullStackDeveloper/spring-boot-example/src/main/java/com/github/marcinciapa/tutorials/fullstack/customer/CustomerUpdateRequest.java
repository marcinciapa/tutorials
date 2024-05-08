package com.github.marcinciapa.tutorials.fullstack.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
