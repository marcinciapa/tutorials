package com.github.marcinciapa.chapter4.problem95;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void shouldSum() {
        // given
        var numbers = List.of(4, 6, 7);
        var expectedResult = 17;
        var calculator = new Calculator(numbers);

        // when
        var result = calculator.sum();

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldMultiply() {
        // given
        var numbers = List.of(2, 3, 4);
        var expectedResult = 24;
        Calculator calculator = new Calculator(numbers);

        // when
        var result = calculator.multiply();

        // then
        assertEquals(expectedResult, result);
    }
}
