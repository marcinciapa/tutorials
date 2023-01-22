package com.github.marcinciapa.chapter1.problem18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class AnagramDiscovererTest<T extends AnagramDiscoverer> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("shouldThrowWhenInputIllegalArguments")
    void shouldThrowWhenInputIllegal(String inputString1, String inputString2) {
        T anagramDiscoverer = createInstance();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                anagramDiscoverer.areAnagrams(inputString1, inputString2)
        );
    }

    static Stream<Arguments> shouldThrowWhenInputIllegalArguments() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, "abc"),
                Arguments.of("abc", null)
        );
    }

    @ParameterizedTest
    @MethodSource("shouldConfirmAreAnagramsInput")
    void shouldConfirmAreAnagrams(String inputString1, String inputString2) {
        T anagramDiscoverer = createInstance();
        assertTrue(anagramDiscoverer.areAnagrams(inputString1, inputString2));
    }

    static Stream<Arguments> shouldConfirmAreAnagramsInput() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("     ", ""),
                Arguments.of("     ", "\t\n"),
                Arguments.of("abc", "abc"),
                Arguments.of("abc", "bca"),
                Arguments.of("abc", "CBA"),
                Arguments.of("abc", "a b c"),
                Arguments.of("abc", "C B A")
        );
    }

    @ParameterizedTest
    @MethodSource("shouldDenyAreAnagramsInput")
    void shouldDenyAreAnagrams(String inputString1, String inputString2) {
        T anagramDiscoverer = createInstance();
        assertFalse(anagramDiscoverer.areAnagrams(inputString1, inputString2));
    }

    static Stream<Arguments> shouldDenyAreAnagramsInput() {
        return Stream.of(
                Arguments.of("", "abc"),
                Arguments.of(" ", "abc"),
                Arguments.of("", "a b c"),
                Arguments.of("", "   a"),
                Arguments.of("abc", "abf")
        );
    }
}
