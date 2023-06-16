package com.github.marcinciapa.chapter5.problem102;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

abstract class ArrayComparatorTest<T extends ArrayComparator> {

    abstract T comparator();

    @ParameterizedTest
    @MethodSource("nullArray")
    void shouldThrowExceptionWhenArrayNull(int[] array1, int[] array2) {
        assertThrows(IllegalArgumentException.class, () -> comparator().compare(array1, array2));
    }

    private static Stream<Arguments> nullArray() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new int[]{0, 1, 2}),
                Arguments.of(new int[]{0, 1, 2}, null)
        );
    }

    @ParameterizedTest
    @MethodSource("equalArrays")
    void shouldReturn0WhenArraysEqual(int[] array1, int[] array2) {
        // when
        int result = comparator().compare(array1, array2);

        // then
        assertEquals(0, result);
    }

    private static Stream<Arguments> equalArrays() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{3, 2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("array2Greater")
    void shouldReturnNegativeWhenArray2Greater(int[] array1, int[] array2) {
        // when
        int result = comparator().compare(array1, array2);

        // then
        assertTrue(result < 0);
    }

    private static Stream<Arguments> array2Greater() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{1}),
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
                Arguments.of(new int[]{1}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2}, new int[]{3}),
                Arguments.of(new int[]{1, 2, 2, 3}, new int[]{1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("array1Greater")
    void shouldReturnPositiveWhenArray1Greater(int[] array1, int[] array2) {
        // when
        int result = comparator().compare(array1, array2);

        // then
        assertTrue(result > 0);
    }

    private static Stream<Arguments> array1Greater() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{}),
                Arguments.of(new int[]{2, 1}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2}, new int[]{1}),
                Arguments.of(new int[]{3}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 2, 3})
        );
    }
}
