package com.github.marcinciapa.chapter1.problem28;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class IntUnsignedConverterTest<T extends IntUnsignedConverter> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldSuccessfullyConvertToUnsigned(int converted, long expectedResult) {
        // given
        T instance = createInstance();

        // when
        long result = instance.toUnsigned(converted);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(-1, 1L + Integer.MAX_VALUE + Integer.MAX_VALUE),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE, 1L + Integer.MAX_VALUE)
        );
    }
}
