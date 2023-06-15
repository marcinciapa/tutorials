package com.github.marcinciapa.chapter5.problem101;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

abstract class ArrayMismatchFinderTest<T extends ArrayMismatchFinder> {

    abstract T mismatchFinder();

    @ParameterizedTest
    @MethodSource("nullArray")
    void shouldFailIfArrayIsNull(int[] array1, int[] array2) {
        assertThrows(IllegalArgumentException.class, () -> mismatchFinder().mismatch(array1, array2));
    }

    @ParameterizedTest
    @MethodSource("equalArrays")
    void shouldReturnEmptyOptionalWhenArraysEqual(int[] array1, int[] array2) {
        // given
        T mismatchFinder = mismatchFinder();

        // when
        Optional<Integer> result = mismatchFinder.mismatch(array1, array2);

        // then
        assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("notEqualArrays")
    void shouldReturnIndexWhenArrayNotEqual(int[] array1, int[] array2, int mismatchIndex) {
        // given
        T mismatchFinder = mismatchFinder();

        // when
        Optional<Integer> result = mismatchFinder.mismatch(array1, array2);

        // then
        assertTrue(result.isPresent());
        assertEquals(mismatchIndex, result.get());
    }

    private static Stream<Arguments> nullArray() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new int[]{0, 1, 2}),
                Arguments.of(new int[]{0, 1, 2}, null)
        );
    }

    private static Stream<Arguments> equalArrays() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{1, 2, 3, 3, 4}, new int[]{1, 2, 3, 3, 4})
        );
    }

    private static Stream<Arguments> notEqualArrays() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{0}, 0),
                Arguments.of(new int[]{1}, new int[]{2}, 0),
                Arguments.of(new int[]{1}, new int[]{1, 2}, 1),
                Arguments.of(new int[]{1, 2}, new int[]{1, 0}, 1),
                Arguments.of(new int[]{1, 2, 3, 3, 4}, new int[]{1, 2, 3, 4}, 3)
        );
    }
}
