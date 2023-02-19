package com.github.marcinciapa.chapter1.problem3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggestedWordsReverserTest {

    private final SuggestedWordsReverser wordsReverser = new SuggestedWordsReverser();

    @ParameterizedTest
    @MethodSource("com.github.marcinciapa.chapter1.problem3.TestInputProvider#testInputWordsInverter")
    void shouldInvertWordsInString(String inputString, String expectedResult) {
        assertEquals(expectedResult, wordsReverser.reverseWordsInString(inputString));
    }
}
