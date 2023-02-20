package com.github.marcinciapa.chapter2.problem40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class NullCheckerTest<T extends NullChecker> {

    abstract T createChecker();

    @Test
    void shouldVerifyFalse() {
        assertFalse(createChecker().isNull("not null"));
    }

    @Test
    void shouldVerifyTrue() {
        assertTrue(createChecker().isNull(null));
    }
}
