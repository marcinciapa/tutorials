package com.github.marcinciapa.chapter2.problem43;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class NullCheckerTest<T extends NullChecker> {

    abstract T createInstance();

    @Test
    void shouldReturnSameObjectThatPassed() {
        // given
        T checker = createInstance();

        // when
        String result = checker.nonNullOrDefault("Passed string");

        // then
        assertEquals("Passed string", result);
    }

    @Test
    void shouldReturnDefaultObjectWhenNullPassed() {
        // given
        T checker = createInstance();

        // when
        String result = checker.nonNullOrDefault(null);

        // then
        assertEquals("Default string", result);
    }
}
