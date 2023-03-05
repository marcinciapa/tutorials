package com.github.marcinciapa.chapter2.problem49;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImmutableClassTest {

    @Test
    void shouldClassBeImmutable() {
        // given
        int x = 1;
        int y = 2;
        ImmutableClass immutableObject = new ImmutableClass(x, y);
        int x1 = immutableObject.x();
        int y1 = immutableObject.y();

        // when
        x = -1;
        y = -2;
        x1 = 0;
        y1 = 0;

        // then
        assertEquals(1, immutableObject.x());
        assertEquals(2, immutableObject.y());
    }
}
