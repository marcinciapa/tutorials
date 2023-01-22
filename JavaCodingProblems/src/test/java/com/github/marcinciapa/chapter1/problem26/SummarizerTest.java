package com.github.marcinciapa.chapter1.problem26;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class SummarizerTest<T extends Summarizer> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("overflowingTestInput")
    void shouldThrowArithmeticExceptionOnOverflow(int number1, int number2) {
        T summarizer = createInstance();
        assertThrows(ArithmeticException.class, () ->
                System.out.println(summarizer.sum(number1, number2))
        );
    }

    static Stream<Arguments> overflowingTestInput() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE, 1),
                Arguments.of(1, Integer.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE, -1),
                Arguments.of(-1, Integer.MIN_VALUE),
                Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("correctTestInput")
    void shouldCalculateSumCorrectly(int number1, int number2, int expectedSum) {
        // given
        T summarizer = createInstance();

        // when
        int sum = summarizer.sum(number1, number2);

        // then
        assertEquals(expectedSum, sum);
    }

    static Stream<Arguments> correctTestInput() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE - 1, 1, Integer.MAX_VALUE),
                Arguments.of(1, Integer.MAX_VALUE - 1, Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE + 1, -1, Integer.MIN_VALUE),
                Arguments.of(-1, Integer.MIN_VALUE + 1, Integer.MIN_VALUE),
                Arguments.of(0, Integer.MIN_VALUE, Integer.MIN_VALUE),
                Arguments.of(Integer.MIN_VALUE, 0, Integer.MIN_VALUE),
                Arguments.of(0, Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE, 0, Integer.MAX_VALUE),
                Arguments.of(0, 0, 0),
                Arguments.of(0, 1, 1),
                Arguments.of(1, 0, 1),
                Arguments.of(0, -1, -1),
                Arguments.of(-1, 0, -1),
                Arguments.of(-1, -1, -2),
                Arguments.of(1, 1, 2),
                Arguments.of(1, -1, 0),
                Arguments.of(-1, 1, 0)
        );
    }
}
