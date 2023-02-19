package com.github.marcinciapa.chapter1.problem5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggestedLettersCounterTest {

    private final SuggestedLettersCounter lettersCounter = new SuggestedLettersCounter();

    @ParameterizedTest
    @MethodSource("com.github.marcinciapa.chapter1.problem5.TestInput#vowelsCountInput")
    void shouldCountVowels(String inputString, int expectedCount) {
        assertEquals(expectedCount, lettersCounter.countVowels(inputString));
    }

    @ParameterizedTest
    @MethodSource("com.github.marcinciapa.chapter1.problem5.TestInput#consonantsCountInput")
    void shouldCountConsonants(String inputString, int expectedCount) {
        assertEquals(expectedCount, lettersCounter.countConsonants(inputString));
    }
}
