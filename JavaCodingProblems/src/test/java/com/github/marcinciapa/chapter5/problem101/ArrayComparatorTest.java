package com.github.marcinciapa.chapter5.problem101;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

abstract class ArrayComparatorTest<T extends ArrayComparator> {

    abstract T comparator();

    @ParameterizedTest
    @MethodSource("nullArrays")
    void shouldFailWhenArrayNull(int[] array1, int[] array2) {
        assertThrows(IllegalArgumentException.class, () -> comparator().areEqual(array1, array2));
    }

    @ParameterizedTest
    @MethodSource("notEqualArrays")
    void shouldReturnFalseWhenArraysNotEqual(int[] array1, int[] array2) {
        // given
        T comparator = comparator();

        // when
        boolean result = comparator.areEqual(array1, array2);

        // then
        assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("equalArrays")
    void shouldReturnTrueWhenArraysEqual(int[] array1, int[] array2) {
        // given
        T comparator = comparator();

        // when
        boolean result = comparator.areEqual(array1, array2);

        // then
        assertTrue(result);
    }

    private static Stream<Arguments> nullArrays() {
        return Stream.of(
                Arguments.of(null, new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 2, 3}, null),
                Arguments.of(null, null)
        );
    }

    private static Stream<Arguments> notEqualArrays() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3, 2, 1}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3})
        );
    }

    private static Stream<Arguments> equalArrays() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{3, 2, 1})
        );
    }
}
