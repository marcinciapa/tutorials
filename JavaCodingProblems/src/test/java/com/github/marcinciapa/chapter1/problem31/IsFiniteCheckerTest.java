package com.github.marcinciapa.chapter1.problem31;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class IsFiniteCheckerTest<T extends IsFiniteChecker> {

    abstract IsFiniteChecker createInstance();

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldDetectIfIsFinite(float number, boolean expectedResult) {
        // given
        IsFiniteChecker instance = createInstance();

        // when
        boolean result = instance.isFinite(number);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(0, true),
                Arguments.of(1.11f, true),
                Arguments.of(-1.11f, true),
                Arguments.of(1/3, true),
                Arguments.of(-1/3, true),
                Arguments.of(Float.NaN, false),
                Arguments.of(Float.POSITIVE_INFINITY, false),
                Arguments.of(Float.NEGATIVE_INFINITY, false)
        );
    }
}
