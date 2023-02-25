package com.github.marcinciapa.chapter2.problem42;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class NullCheckerTest<T extends NullChecker> {

    abstract T createInstance();

    @Test
    void shouldThrowExceptionForNull() {
        T instance = createInstance();
        assertThrows(IllegalArgumentException.class, () -> instance.requireNonNullOrThrow(null));
    }

    @Test
    void shouldDoNothingForNonNull() {
        T instance = createInstance();
        String result = instance.requireNonNullOrThrow("this is not null");
        assertEquals("this is not null", result);
    }
}
