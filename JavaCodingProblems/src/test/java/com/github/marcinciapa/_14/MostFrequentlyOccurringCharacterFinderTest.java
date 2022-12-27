package com.github.marcinciapa._14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface MostFrequentlyOccurringCharacterFinderTest<T extends MostFrequentlyOccurringCharacterFinder> {

    T createInstance();

    @ParameterizedTest
    @MethodSource("testData")
    default void shouldFindMostlyOccurringCharacter(
            String inputString,
            @SuppressWarnings("OptionalUsedAsFieldOrParameterType") Optional<Character> expectedResult) {

        T instance = createInstance();
        assertEquals(expectedResult, instance.findMostFrequentlyOccurringCharacter(inputString));
    }


    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(null, Optional.empty()),
                Arguments.of("", Optional.empty()),
                Arguments.of("a", Optional.of('a')),
                Arguments.of("aba", Optional.of('a')),
                Arguments.of("bbaa", Optional.of('a')),
                Arguments.of("bbddccaaeeff", Optional.of('a')),
                Arguments.of("aabb", Optional.of('a'))
        );
    }
}
