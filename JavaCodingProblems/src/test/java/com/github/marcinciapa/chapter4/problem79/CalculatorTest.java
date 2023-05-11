package com.github.marcinciapa.chapter4.problem79;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class CalculatorTest<T extends Calculator> {

    abstract T calculator(int number1, int number2);

    @Test
    void shouldSubtract() {
        // given
        T calculator = calculator(5, 2);
        var expectedResult = 3L;

        // when
        var result = calculator.subtract();

        // then
        assertEquals(expectedResult, result);
    }
}
