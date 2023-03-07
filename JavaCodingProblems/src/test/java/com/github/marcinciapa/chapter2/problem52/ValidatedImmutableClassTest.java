package com.github.marcinciapa.chapter2.problem52;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class ValidatedImmutableClassTest<T extends ValidatedImmutableClass> {

    abstract ValidatedImmutableClassBuilder<T> builder();

    @Test
    void shouldAllowPositiveValue() {
        ValidatedImmutableClass immutableObject = builder().withValue(1).build();
        assertEquals(1, immutableObject.value());
    }

    @Test
    void shouldAllowZeroValue() {
        ValidatedImmutableClass immutableObject = builder().withValue(0).build();
        assertEquals(0, immutableObject.value());
    }

    @Test
    void shouldThrowWhenNegativeValueSet() {
        ValidatedImmutableClassBuilder<T> builder = builder().withValue(-1);
        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void shouldThrowWhenValueNotSet() {
        ValidatedImmutableClassBuilder<T> builder = builder();
        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void shouldThrowWhenNullValueSet() {
        ValidatedImmutableClassBuilder<T> builder = builder().withValue(null);
        assertThrows(IllegalStateException.class, builder::build);
    }
}
