package com.github.marcinciapa.chapter1.problem32;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class BoolOperatorTest<T extends BoolOperator> {

    abstract T createInstance();

    @Test
    void shouldResolveAnd() {
        T operator = createInstance();
        assertFalse(operator.and(false, false));
        assertFalse(operator.and(false, true));
        assertFalse(operator.and(true, false));
        assertTrue(operator.and(true, true));
    }

    @Test
    void shouldResolveOr() {
        T operator = createInstance();
        assertFalse(operator.or(false, false));
        assertTrue(operator.or(false, true));
        assertTrue(operator.or(true, false));
        assertTrue(operator.or(true, true));
    }

    @Test
    void shouldResolveXor() {
        T operator = createInstance();
        assertFalse(operator.xor(false, false));
        assertTrue(operator.xor(false, true));
        assertTrue(operator.xor(true, false));
        assertFalse(operator.xor(true, true));
    }
}
