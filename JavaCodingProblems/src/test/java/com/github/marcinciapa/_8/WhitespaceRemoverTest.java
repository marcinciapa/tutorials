package com.github.marcinciapa._8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface WhitespaceRemoverTest<T extends WhitespaceRemover> {

    T createRemover();

    @ParameterizedTest
    @MethodSource("testInput")
    default void shouldRemoveWhitespaces(String inputString, String expectedResult) {
        T whitespaceRemover = createRemover();
        assertEquals(expectedResult, whitespaceRemover.removeWhitespace(inputString));
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", ""),
                Arguments.of(" ", ""),
                Arguments.of("   a  a\na", "aaa"),
                Arguments.of("aa", "aa"),
                Arguments.of("a a ", "aa"),
                Arguments.of("a\t", "a")
        );
    }
}
