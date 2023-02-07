package com.github.marcinciapa.chapter1.problem35;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class FloorCalculatorTest<T extends FloorCalculator> {

    abstract T createInstance();

    @Test
    void shouldFailWhileDividingByZero() {
        T calculator = createInstance();
        assertThrows(ArithmeticException.class, () -> calculator.floorDivision(2, 0));
    }

    @ParameterizedTest
    @MethodSource("floorDivisionTestInput")
    void shouldCalculateFloorDivision(int dividend, int divisor, int expectedResult) {
        // given
        T calculator = createInstance();

        // when
        int result = calculator.floorDivision(dividend, divisor);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> floorDivisionTestInput() {
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(0, -1, 0),

                Arguments.of(1, 1, 1),
                Arguments.of(6, 2, 3),
                Arguments.of(6, 4, 1),

                Arguments.of(-1, -1, 1),
                Arguments.of(-6, -2, 3),
                Arguments.of(-6, -4, 1),

                Arguments.of(-1, 1, -1),
                Arguments.of(-6, 2, -3),
                Arguments.of(-6, 4, -2),

                Arguments.of(1, -1, -1),
                Arguments.of(6, -2, -3),
                Arguments.of(6, -4, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("floorModulusTestInput")
    void shouldCalculateFloorModulus(int dividend, int divisor, int expectedResult) {
        // given
        T calculator = createInstance();

        // when
        int result = calculator.floorModulus(dividend, divisor);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> floorModulusTestInput() {
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(0, -1, 0),

                Arguments.of(1, 1, 0),
                Arguments.of(6, 2, 0),
                Arguments.of(6, 4, 2),

                Arguments.of(-1, -1, 0),
                Arguments.of(-6, -2, 0),
                Arguments.of(-6, -4, -2),

                Arguments.of(-1, 1, 0),
                Arguments.of(-6, 2, 0),
                Arguments.of(-6, 4, 2),

                Arguments.of(1, -1, 0),
                Arguments.of(6, -2, 0),
                Arguments.of(6, -4, -2)
        );
    }

    @Test
    void shouldFailWhileModByZero() {
        T calculator = createInstance();
        assertThrows(ArithmeticException.class, () -> calculator.floorModulus(2, 0));
    }
}
