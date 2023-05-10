package com.github.marcinciapa.chapter4.problem78;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class CalculatorTest<T extends Calculator> {

    abstract T calculator(int number1, int number2);

    @Test
    void shouldAdd() {
        // given
        T calculator = calculator(1, 2);
        var expectedResult = 3;

        // when
        var result = calculator.sum();

        // then
        assertEquals(expectedResult, result);
    }
}
