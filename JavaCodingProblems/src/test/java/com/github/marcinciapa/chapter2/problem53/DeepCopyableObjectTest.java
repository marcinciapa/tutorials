package com.github.marcinciapa.chapter2.problem53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class DeepCopyableObjectTest<T extends CopyableObject & DeepCopyableObject> {

    abstract T createInstance(int x, int y, int z);

    @Test
    void shouldCreateDeepCopy() {
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
        assertEquals(2, copy.getZ());
    }
}
