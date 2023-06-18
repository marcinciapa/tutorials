package com.github.marcinciapa.chapter5.problem104;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class ArrayAggregatorTest<T extends ArrayAggregator> {

    abstract T aggregator(int[] array);

    @Test
    void shouldFailWhenInitializedWithNull() {
        assertThrows(IllegalArgumentException.class, () -> aggregator(null));
    }

    @Test
    void shouldFailWhenInitializedWithEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> aggregator(new int[]{}));
    }

    @ParameterizedTest
    @MethodSource("multiValueArray")
    void shouldCalculateMin(int[] array, int expectedMin, int expectedMax, int expectedAvg) {
        // given
        T aggregator = aggregator(array);

        // when
        int result = aggregator.min();

        // then
        assertEquals(expectedMin, result);
    }

    @ParameterizedTest
    @MethodSource("multiValueArray")
    void shouldCalculateMax(int[] array, int expectedMin, int expectedMax, int expectedAvg) {
        // given
        T aggregator = aggregator(array);

        // when
        int result = aggregator.max();

        // then
        assertEquals(expectedMax, result);
    }

    static Stream<Arguments> multiValueArray() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1, 1, 1),
                Arguments.of(new int[]{2, 2, 6, 10, 10}, 2, 10, 6)
        );
    }

}
