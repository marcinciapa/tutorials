package com.github.marcinciapa._11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

interface PalindromeCheckerTest<T extends PalindromeChecker> {

    T createInstance();

    @Test
    default void shouldThrowExceptionWhenNullProvided() {
        T palindromeChecker = createInstance();
        assertThrows(IllegalArgumentException.class, () ->
                palindromeChecker.isPalindrome(null)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    default void shouldProvideExpectedResult(String inputString, boolean expectedValue) {
        T palindromeChecker = createInstance();
        assertEquals(expectedValue, palindromeChecker.isPalindrome(inputString));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("a", true),
                Arguments.of("aa", true),
                Arguments.of("aaa", true),
                Arguments.of("abba", true),
                Arguments.of("abcba", true),
                Arguments.of("abcabc", false),
                Arguments.of("abcab", false)
        );
    }

}
