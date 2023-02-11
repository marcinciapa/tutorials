package com.github.marcinciapa.chapter1.problem38;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class FMATest<T extends FMA> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldCalculateFma(float a, float b, float c, float expectedResult) {
        // given
        T fma = createInstance();

        // when
        float result = fma.calculate(a, b, c);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(0f, 0f, 0f, 0f),
                Arguments.of(0f, 0f, 2f, 2f),
                Arguments.of(0f, 2f, 0f, 0f),
                Arguments.of(2f, 0f, 0f, 0f),
                Arguments.of(0f, 2f, 2f, 2f),
                Arguments.of(2f, 0f, 2f, 2f),
                Arguments.of(2f, 2f, 0f, 4f),
                Arguments.of(2f, 2f, 2f, 6f)
        );
    }
}
