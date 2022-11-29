package com.github.marcinciapa._3;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class TestInputProvider {

    static Stream<Arguments> testInputLettersInverter() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", ""),
                Arguments.of(" ", " "),
                Arguments.of("a", "a"),
                Arguments.of(" a", " a"),
                Arguments.of("a ", "a "),
                Arguments.of("abc", "cba"),
                Arguments.of("a b", "a b"),
                Arguments.of("abc def", "cba fed"),
                Arguments.of("abc def ghi", "cba fed ihg")

        );
    }

    static Stream<Arguments> testInputWordsInverter() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", ""),
                Arguments.of(" ", " "),
                Arguments.of("a", "a"),
                Arguments.of(" a", "a "),
                Arguments.of("a ", " a"),
                Arguments.of("abc", "abc"),
                Arguments.of("a b", "b a"),
                Arguments.of("abc def", "def abc"),
                Arguments.of("abc def ghi", "ghi def abc")

        );
    }
}
