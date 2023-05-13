package com.github.marcinciapa.chapter4.problem80;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class CalculatorTest<T extends Calculator<U>, U extends Number> {

    abstract T calculator(int number1, int number2);
    abstract U expectedResult(int number1, int number2);

    @Test
    void shouldMultiply() {
        // given
        T calculator = calculator(2, 3);
        var expectedResult = expectedResult(2, 3);

        // when
        var result = calculator.multiply();

        // then
        assertEquals(expectedResult, result);
    }
}
