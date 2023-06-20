package com.github.marcinciapa.chapter5.problem106;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class ArrayFillerTest<T extends ArrayFiller> {

    abstract T filler();

    @Test
    void shouldFailWhenArrayNull() {
        assertThrows(IllegalArgumentException.class, () -> filler().fillWithFibonacci(null));
    }

    @ParameterizedTest
    @MethodSource("arrayToFill")
    void shouldFillArray(int[] array, int[] expectedArray) {
        // when
        filler().fillWithFibonacci(array);

        // then
        assertArrayEquals(expectedArray, array);
    }

    static Stream<Arguments> arrayToFill() {
        return Stream.of(
                Arguments.of(new int[0], new int[]{}),
                Arguments.of(new int[1], new int[]{1}),
                Arguments.of(new int[2], new int[]{1, 1}),
                Arguments.of(new int[3], new int[]{1, 1, 2}),
                Arguments.of(new int[6], new int[]{1, 1, 2, 3, 5, 8})
        );
    }
}
