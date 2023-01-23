package com.github.marcinciapa.chapter1.problem30;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class UnsignedDividerTest<T extends UnsignedDivider> {

    abstract T createInstance();

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        T instance = createInstance();
        assertThrows(ArithmeticException.class, () ->
                instance.divide(1, 0)
        );
    }

    @Test
    void shouldThrowExceptionWhenModuloByZero() {
        T instance = createInstance();
        assertThrows(ArithmeticException.class, () ->
                instance.modulo(1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("divideTestInput")
    void shouldDivideCorrectly(int dividend, int divisor, long expectedResult) {
        // given
        T instance = createInstance();

        // when
        long result = instance.divide(dividend, divisor);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> divideTestInput() {
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(0, Integer.MAX_VALUE, 0),
                Arguments.of(0, Integer.MIN_VALUE, 0),
                Arguments.of(0, -1, 0),

                Arguments.of(1, 1, 1),
                Arguments.of(1, Integer.MAX_VALUE, 0),
                Arguments.of(1, Integer.MIN_VALUE, 0),
                Arguments.of(1, -1, 0),

                Arguments.of(-1, 1, 1L + Integer.MAX_VALUE + Integer.MAX_VALUE),
                Arguments.of(-1, Integer.MAX_VALUE, 2),
                Arguments.of(-1, Integer.MIN_VALUE, 1),
                Arguments.of(-1, -1, 1),

                Arguments.of(Integer.MAX_VALUE, 1, Integer.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, 0),
                Arguments.of(Integer.MAX_VALUE, -1, 0),

                Arguments.of(Integer.MIN_VALUE, 1, 1L + Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, -1, 0)

        );
    }

    @ParameterizedTest
    @MethodSource("moduloTestInput")
    void shouldModuloCorrectly(int dividend, int divisor, long expectedResult) {
        // given
        T instance = createInstance();

        // when
        long result = instance.modulo(dividend, divisor);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> moduloTestInput() {
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(0, Integer.MAX_VALUE, 0),
                Arguments.of(0, Integer.MIN_VALUE, 0),
                Arguments.of(0, -1, 0),

                Arguments.of(1, 1, 0),
                Arguments.of(1, Integer.MAX_VALUE, 1),
                Arguments.of(1, Integer.MIN_VALUE, 1),
                Arguments.of(1, -1, 1),

                Arguments.of(-1, 1, 0),
                Arguments.of(-1, Integer.MAX_VALUE, 1),
                Arguments.of(-1, Integer.MIN_VALUE, Integer.MAX_VALUE),
                Arguments.of(-1, -1, 0),

                Arguments.of(Integer.MAX_VALUE, 1, 0),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, 0),
                Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE, -1, Integer.MAX_VALUE),

                Arguments.of(Integer.MIN_VALUE, 1, 0),
                Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE, 0),
                Arguments.of(Integer.MIN_VALUE, -1, 1L + Integer.MAX_VALUE)

        );
    }
}
