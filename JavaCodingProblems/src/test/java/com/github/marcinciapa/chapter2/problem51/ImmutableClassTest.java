package com.github.marcinciapa.chapter2.problem51;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImmutableClassTest {

    @Test
    void shouldClassBeImmutable() {
        // given
        int x = 1;
        int y = 2;
        int mandatory = 3;
        ImmutableClass immutableObject = ImmutableClass.builder(mandatory)
                .withX(x)
                .withY(y)
                .build();
        int x1 = immutableObject.x();
        int y1 = immutableObject.y();
        int mandatory1 = immutableObject.mandatory();

        // when
        x = -1;
        y = -2;
        mandatory = -3;
        x1 = 0;
        y1 = 0;
        mandatory1 = 0;

        // then
        assertEquals(1, immutableObject.x());
        assertEquals(2, immutableObject.y());
        assertEquals(3, immutableObject.mandatory());
    }
}
