package com.github.marcinciapa.chapter2.problem52;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatedImmutableClassTest {

    @Test
    void shouldApplyNonNullValue() {
        ValidatedImmutableClass immutableObject = ValidatedImmutableClass.builder().withValue(0).build();
        assertEquals(0, immutableObject.value());
    }

    @Test
    void shouldThrowWhenValueNotSet() {
        ValidatedImmutableClass.Builder builder = ValidatedImmutableClass.builder();
        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void shouldThrowWhenNullValueSet() {
        ValidatedImmutableClass.Builder builder = ValidatedImmutableClass.builder().withValue(null);
        assertThrows(IllegalStateException.class, builder::build);
    }
}
