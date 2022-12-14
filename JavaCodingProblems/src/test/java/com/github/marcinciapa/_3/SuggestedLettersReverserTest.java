package com.github.marcinciapa._3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggestedLettersReverserTest {

    private final SuggestedLettersReverser lettersReverser = new SuggestedLettersReverser();

    @ParameterizedTest
    @MethodSource("com.github.marcinciapa._3.TestInputProvider#testInputLettersInverter")
    void shouldInvertLettersInWords(String inputString, String expectedResult) {
        assertEquals(expectedResult, lettersReverser.reverseLettersInWords(inputString));
    }
}
