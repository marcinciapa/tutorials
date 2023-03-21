package com.github.marcinciapa.chapter2.problem54;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToStringOverriderTest {

    @Test
    void shouldOverwriteToString() {
        // given
        ToStringOverrider toStringOverrider = new ToStringOverrider();

        // when
        String result = String.valueOf(toStringOverrider);

        // then
        assertEquals("Overwritten toString", result);
    }
}
