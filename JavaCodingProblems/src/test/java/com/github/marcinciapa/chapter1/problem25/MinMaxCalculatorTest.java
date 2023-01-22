package com.github.marcinciapa.chapter1.problem25;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class MinMaxCalculatorTest<T extends MinMaxCalculator> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("shouldCalculateMaxInput")
    void shouldCalculateMax(int number1, int number2, int expectedResult) {
        // given
        T instance = createInstance();

        // when
        int max = instance.max(number1, number2);

        // then
        assertEquals(expectedResult, max);
    }

    @ParameterizedTest
    @MethodSource("shouldCalculateMinInput")
    void shouldCalculateMin(int number1, int number2, int expectedResult) {
        // given
        T instance = createInstance();

        // when
        int max = instance.min(number1, number2);

        // then
        assertEquals(expectedResult, max);
    }

    static Stream<Arguments> shouldCalculateMaxInput() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(15, 15, 15),
                Arguments.of(-1, -1, -1),
                Arguments.of(-15, 1, 1),
                Arguments.of(15, 1, 15),
                Arguments.of(0, -20, 0)
        );
    }

    static Stream<Arguments> shouldCalculateMinInput() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(15, 15, 15),
                Arguments.of(-1, -1, -1),
                Arguments.of(-15, 1, -15),
                Arguments.of(15, 1, 1),
                Arguments.of(0, -20, -20)
        );
    }
}
