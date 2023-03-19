package com.github.marcinciapa.chapter2.problem53.c;

import com.github.marcinciapa.chapter2.problem53.c.ConstructorShallowCopy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstructorShallowCopyTest {

    @Test
    void shouldCloneWithConstructor() {
        // given
        ConstructorShallowCopy original = new ConstructorShallowCopy(0.2, -1.4);

        // when
        ConstructorShallowCopy copy = new ConstructorShallowCopy(original);

        // then
        assertEquals(original.x(), copy.x());
        assertEquals(original.y(), copy.y());
    }
}
