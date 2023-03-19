package com.github.marcinciapa.chapter2.problem53;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class DeepCopyableObjectTest<T extends CopyableObject & DeepCopyableObject> {

    abstract T createInstance(int x, int y, int z);

    @Test
    void shouldCreateDeepCopy() {
        // given
        T original = createInstance(1, 2, 3);

        // when
        CopyableObject copy = original.copy();
        original.setX(4);
        original.setY(5);
        original.setZ(6);

        // then
        assertEquals(1, copy.getX());
        assertEquals(2, copy.getY());
        assertEquals(3, copy.getZ());
    }
}
