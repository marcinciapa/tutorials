package com.github.marcinciapa.chapter2.problem53.a;

import com.github.marcinciapa.chapter2.problem53.a.ManualShallowCopy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManualShallowCopyTest {

    @Test
    void shouldCreateShallowCopyManually() {
        // given
        ManualShallowCopy original = new ManualShallowCopy(0.2, -0.5);

        // when
        ManualShallowCopy clone = original.copy();

        // then
        assertEquals(original.getX(), clone.getX());
        assertEquals(original.getY(), clone.getY());
    }
}
