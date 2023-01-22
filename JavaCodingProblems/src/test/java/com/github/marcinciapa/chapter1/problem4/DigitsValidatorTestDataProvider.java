package com.github.marcinciapa.chapter1.problem4;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class DigitsValidatorTestDataProvider {

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of("", false),
                Arguments.of("123", true),
                Arguments.of("abc", false),
                Arguments.of("a2c", false)
        );
    }
}
