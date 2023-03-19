package com.github.marcinciapa.chapter2.problem53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryDeepCopyTest {

    @Test
    void shouldMakeDeepCopy() {
        // given
        LibraryDeepCopy original = new LibraryDeepCopy(0, 1, new LibraryDeepCopy.InsightObject(2));

        // when
        LibraryDeepCopy copy = original.copy();
        original.setX(3);
        original.setY(4);
        original.setZ(5);

        // then
        assertEquals(0, copy.getX());
        assertEquals(1, copy.getY());
        assertEquals(2, copy.getZ());
    }
}
