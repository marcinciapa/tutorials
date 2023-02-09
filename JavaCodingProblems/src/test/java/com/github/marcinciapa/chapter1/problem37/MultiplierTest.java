package com.github.marcinciapa.chapter1.problem37;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class MultiplierTest<T extends Multiplier> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("exceptionCausingTestInput")
    void shouldThrowExceptionWhenOperationOverflow(int number1, int number2) {
        T multiplier = createInstance();
        assertThrows(ArithmeticException.class, () -> multiplier.multiply(number1, number2));
    }

    static Stream<Arguments> exceptionCausingTestInput() {
        return Stream.of(
                Arguments.of(2, Integer.MAX_VALUE),
                Arguments.of(2, -Integer.MAX_VALUE),
                Arguments.of(-2, Integer.MAX_VALUE),
                Arguments.of(-2, -Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldMultiplyTwoNumbers(int number1, int number2, int expectedResult) {
        // given
        T multiplier = createInstance();

        // when
        int result = multiplier.multiply(number1, number2);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 5, 0),
                Arguments.of(0, -5, 0),
                Arguments.of(1, 5, 5),
                Arguments.of(1, -5, -5),
                Arguments.of(-1, 5, -5),
                Arguments.of(-1, -5, 5),
                Arguments.of(3, 5, 15),
                Arguments.of(3, -5, -15),
                Arguments.of(-3, 5, -15),
                Arguments.of(-3, -5, 15),
                Arguments.of(1, Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.of(1, -Integer.MAX_VALUE, -Integer.MAX_VALUE),
                Arguments.of(-1, Integer.MAX_VALUE, -Integer.MAX_VALUE),
                Arguments.of(-1, -Integer.MAX_VALUE, Integer.MAX_VALUE)
        );
    }
}
