package com.github.marcinciapa.chapter1.problem16;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

interface SubstringFinderTest<T extends SubstringFinder> {

    T getInstance();

    @ParameterizedTest
    @MethodSource("shouldFindSubstringTestInput")
    default void shouldFindSubstring(String inputString, String substring) {
        SubstringFinder finder = getInstance();
        assertTrue(finder.contains(substring, inputString));
    }

    @ParameterizedTest
    @MethodSource("shouldNotFindSubstringTestInput")
    default void shouldNotFindSubstring(String inputString, String substring) {
        SubstringFinder finder = getInstance();
        assertFalse(finder.contains(substring, inputString));
    }

    static Stream<Arguments> shouldFindSubstringTestInput() {
        return Stream.of(
                Arguments.of("containing substring", "substring"),
                Arguments.of("substring contained", "substring"),
                Arguments.of("containing substring contained", "substring"),
                Arguments.of("string", ""),
                Arguments.of("", ""),
                Arguments.of("abc\\def", "\\")
        );
    }

    static Stream<Arguments> shouldNotFindSubstringTestInput() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", null),
                Arguments.of(null, ""),
                Arguments.of("", "substring"),
                Arguments.of("string", "substring")
        );
    }
}
