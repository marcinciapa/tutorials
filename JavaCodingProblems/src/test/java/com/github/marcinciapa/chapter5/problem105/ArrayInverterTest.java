package com.github.marcinciapa.chapter5.problem105;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class ArrayInverterTest<T extends ArrayInverter> {

    abstract T inverter();

    @Test
    void shouldFailOnNullArray() {
        assertThrows(IllegalArgumentException.class, () -> inverter().invert(null));
    }

    @Test
    void shouldInvertEmptyArray() {
        // given
        int[] arrayToInvert = new int[]{};
        int[] expectedResult = new int[]{};
        T inverter = inverter();

        // when
        int[] result = inverter.invert(arrayToInvert);

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldInvertOneElementArray() {
        // given
        int[] arrayToInvert = new int[]{1};
        int[] expectedResult = new int[]{1};
        T inverter = inverter();

        // when
        int[] result = inverter.invert(arrayToInvert);

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldInvertMultiElementArray() {
        // given
        int[] arrayToInvert = new int[]{1, 2, 3, 4, 6, 5};
        int[] expectedResult = new int[]{5, 6, 4, 3, 2, 1};
        T inverter = inverter();

        // when
        int[] result = inverter.invert(arrayToInvert);

        // then
        assertArrayEquals(expectedResult, result);
    }
}
