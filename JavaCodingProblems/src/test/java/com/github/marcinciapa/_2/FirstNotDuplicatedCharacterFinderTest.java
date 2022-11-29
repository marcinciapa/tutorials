package com.github.marcinciapa._2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstNotDuplicatedCharacterFinderTest {

    private final FirstNotDuplicatedCharacterFinder finder = new FirstNotDuplicatedCharacterFinder();

    @ParameterizedTest
    @MethodSource("inputValues")
    void selfInventedSolutionWorks(String inputString, Optional<Character> expectedResult) {
        assertEquals(expectedResult, finder.selfInventedSolution(inputString));
    }

    @ParameterizedTest
    @MethodSource("inputValues")
    void suggestedSolution1Works(String inputString, Optional<Character> expectedResult) {
        assertEquals(expectedResult, finder.suggestedSolution1(inputString));
    }

    private static Stream<Arguments> inputValues() {
        return Stream.of(
                Arguments.of(null, Optional.empty()),
                Arguments.of("", Optional.empty()),
                Arguments.of("abab", Optional.empty()),
                Arguments.of("a", Optional.of('a')),
                Arguments.of("aba", Optional.of('b'))
        );
    }
}
