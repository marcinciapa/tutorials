package com.github.marcinciapa.chapter4.problem98;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberCalculatorTest {

    @Test
    void shouldSumNumbers() {
        // given
         var numbers = List.of(1, 2, 3);
        // var numbers = List.of(1L, 2L, 3L);
        var expectedResult = 6;
        var calculator = new NumberCalculator(numbers);

        // when
        int result = calculator.sum();

        // then
        assertEquals(expectedResult, result);
    }
}
