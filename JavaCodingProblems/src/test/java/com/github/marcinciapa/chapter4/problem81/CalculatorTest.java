package com.github.marcinciapa.chapter4.problem81;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class CalculatorTest<T extends Calculator> {

    abstract T calculator(int number1, int number2);

    @Test
    void shouldSum() {
        // given
        short expectedResult = 5;

        // when
        var result = (short) calculator(2, 3).sum();

        // then
        assertEquals(expectedResult, result);
    }
}
