package com.github.marcinciapa.chapter5.problem108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class ArrayAppenderTest<T extends ArrayAppender> {

    abstract T appender(int[] initialArray);

    @Test
    void shouldFailWhenArrayNull() {
        assertThrows(IllegalArgumentException.class, () -> appender(null));
    }

    @Test
    void shouldFailWhenAppendedElementsNull() {
        T appender = appender(new int[0]);
        assertThrows(IllegalArgumentException.class, () -> appender.append(null));
    }

    @Test
    void shouldReturnSameArrayWhenAppendedElementsEmpty() {
        // given
        int[] initialArray = new int[]{1, 2, 3};
        T appender = appender(initialArray);

        // when
        int[] result = appender.append();

        // then
        assertArrayEquals(initialArray, result);
    }

    @Test
    void shouldAppendOneElementToEmptyArray() {
        // given
        int[] initialArray = new int[0];
        int[] expectedResult = new int[]{1};
        T appender = appender(initialArray);

        // when
        int[] result = appender.append(1);

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldAppendOneElementToNonEmptyArray() {
        // given
        int[] initialArray = new int[]{1, 2, 3};
        int[] expectedResult = new int[]{1, 2, 3, 5};
        T appender = appender(initialArray);

        // when
        int[] result = appender.append(5);

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldAppendThreeElementsToNonEmptyArray() {
        // given
        int[] initialArray = new int[]{1, 2, 3};
        int[] expectedResult = new int[]{1, 2, 3, 5, 3, 4};
        T appender = appender(initialArray);

        // when
        int[] result = appender.append(5, 3, 4);

        // then
        assertArrayEquals(expectedResult, result);
    }
}
