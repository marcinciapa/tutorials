package com.github.marcinciapa.chapter4.problem82;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class CalculatorTest<T extends Calculator> {

    abstract T calculator(int number1, int number2);

    @Test
    void shouldAddNumbers() {
        // given
        var calc = calculator(4, 7); // var should be avoided if the name doesn't reflect type
        int expectedResult = 11;

        // when
        int result = calc.add();

        // then
        assertEquals(expectedResult, result);
    }
}
