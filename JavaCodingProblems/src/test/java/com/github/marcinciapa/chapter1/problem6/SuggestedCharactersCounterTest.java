package com.github.marcinciapa.chapter1.problem6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SuggestedCharactersCounterTest {

    private final SuggestedCharactersCounter counter = new SuggestedCharactersCounter();

    @Test
    void shouldThrowExceptionWhenStringNull() {
        assertThrows(IllegalArgumentException.class, () ->
                counter.countOccurrencesOf('a', null)
        );
    }

    @ParameterizedTest
    @MethodSource("com.github.marcinciapa._6.TestInput#inputData")
    void shouldCountCharacter(String inputString, char countedChar, int expectedCount) {
        assertEquals(expectedCount, counter.countOccurrencesOf(countedChar, inputString));
    }
}
