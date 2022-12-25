package com.github.marcinciapa._12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface CharacterDeduplicatorTest<T extends CharacterDeduplicator> {

    T createInstance();

    @ParameterizedTest
    @MethodSource("testInput")
    default void shouldDeduplicateChars(String inputString, String expectedResult) {
        T deduplicator = createInstance();
        assertEquals(expectedResult, deduplicator.removeDuplicateChars(inputString));
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", ""),
                Arguments.of("abc", "abc"),
                Arguments.of("aaaa", "a"),
                Arguments.of("abba", "ab")
        );
    }
}
