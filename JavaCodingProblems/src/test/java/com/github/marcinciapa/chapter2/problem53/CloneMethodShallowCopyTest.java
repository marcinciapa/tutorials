package com.github.marcinciapa.chapter2.problem53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CloneMethodShallowCopyTest {

    @Test
    void shouldCreateShallowCopyByCloneMethod() throws CloneNotSupportedException {
        // given
        CloneMethodShallowCopy original = new CloneMethodShallowCopy(0.1, 5.3, 6.3);

        // when
        CloneMethodShallowCopy clone = original.clone();

        // then
        assertEquals(original.getX(), clone.getX());
        assertEquals(original.getY(), clone.getY());
        assertEquals(original.getZ(), clone.getZ());
    }
}
