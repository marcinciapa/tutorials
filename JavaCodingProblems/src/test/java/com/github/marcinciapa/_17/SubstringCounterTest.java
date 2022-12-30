package com.github.marcinciapa._17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

abstract class SubstringCounterTest<T extends SubstringCounter> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("shouldThrowExceptionWhenInputIncorrectTestInput")
    void shouldThrowExceptionWhenInputIncorrect(String inputString, String substring) {
        T substringCounter = createInstance();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                substringCounter.countSubstringOccurrences(inputString, substring)
        );
    }

    static Stream<Arguments> shouldThrowExceptionWhenInputIncorrectTestInput() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("abc", null),
                Arguments.of(null, "abc"),
                Arguments.of("abc", "")
        );
    }

    @ParameterizedTest
    @MethodSource("shouldCountSubstringTestInput")
    void shouldCountSubstring(String inputString, String substring, Integer expectedCount) {
        // given
        T substringCounter = createInstance();

        // when
        int substringCount = substringCounter.countSubstringOccurrences(inputString, substring);

        // then
        Assertions.assertEquals(expectedCount, substringCount);
    }

    static Stream<Arguments> shouldCountSubstringTestInput() {
        return Stream.of(
                Arguments.of("", "abc", 0),
                Arguments.of("abc", "abd", 0),
                Arguments.of("abc", "abc", 1),
                Arguments.of("abcabc", "abc", 2),
                Arguments.of("abcdabc", "abc", 2),
                Arguments.of("abcdef", "abc", 1),
                Arguments.of("abcdef", "def", 1),
                Arguments.of("abcdef", "cde", 1),
                Arguments.of("jam jest Andrzej Kmicic", " ", 3),
                Arguments.of("aaa", "aa", 2),
                Arguments.of("\\**\\", "\\", 2),
                Arguments.of("\\**\\", "*", 2)
        );
    }

}
