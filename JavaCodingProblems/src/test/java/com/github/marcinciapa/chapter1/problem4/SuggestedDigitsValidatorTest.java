package com.github.marcinciapa.chapter1.problem4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuggestedDigitsValidatorTest {

    private final SuggestedDigitsValidator validator = new SuggestedDigitsValidator();

    @ParameterizedTest
    @MethodSource("com.github.marcinciapa.chapter1.problem4.DigitsValidatorTestDataProvider#testInput")
    void shouldReturnExpectedValue(String inputString, boolean expectedResult) {
        assertEquals(expectedResult, validator.containsDigitsOnly(inputString));
    }
}
