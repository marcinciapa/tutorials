package com.github.marcinciapa._6;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TestInput {

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of("", 'a', 0),
                Arguments.of("abcd", 'e', 0),
                Arguments.of("a", 'a', 1),
                Arguments.of("abca", 'a', 2)
        );
    }
}
