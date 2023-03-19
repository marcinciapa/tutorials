package com.github.marcinciapa.chapter2.problem53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class ShallowCopyableObjectTest<T extends CopyableObject & ShallowCopyableObject> {

    abstract T createInstance(int x, int y, int z);

    @Test
    void shouldCreateShallowCopy() {
        // given
        T original = createInstance(0, 1, 2);

        // when
        CopyableObject copy = original.copy();
        original.setX(3);
        original.setY(4);
        original.setZ(5);

        // then
        assertEquals(0, copy.getX());
        assertEquals(1, copy.getY());
        assertEquals(5, copy.getZ());
    }
}
