package com.github.marcinciapa.chapter1.problem34;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class LongToIntConverterTest<T extends LongToIntConverter> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("convertTestInput")
    void shouldConvertLongToInt(long input, int expectedOutput) {
        // given
        T converter = createInstance();

        // when
        int output = converter.convert(input);

        // then
        assertEquals(expectedOutput, output);
    }

    static Stream<Arguments> convertTestInput() {
        return Stream.of(
                Arguments.of(0L, 0),
                Arguments.of(1L, 1),
                Arguments.of(-1L, -1),
                Arguments.of((long) Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.of((long) Integer.MIN_VALUE, Integer.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("convertImpossibleTestInput")
    void shouldFailWhenConvertImpossible(long input) {
        T converter = createInstance();
        assertThrows(ArithmeticException.class, () -> converter.convert(input));
    }

    static Stream<Arguments> convertImpossibleTestInput() {
        return Stream.of(
                Arguments.of(1L + Integer.MAX_VALUE),
                Arguments.of(-1L + Integer.MIN_VALUE),
                Arguments.of(Long.MAX_VALUE),
                Arguments.of(Long.MIN_VALUE)
        );
    }
}
