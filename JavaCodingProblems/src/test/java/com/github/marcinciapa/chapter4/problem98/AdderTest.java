package com.github.marcinciapa.chapter4.problem98;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdderTest {

    @Test
    void shouldAddNumbers() {
        // given
        var values = new ArrayList<>();
        // Collection<?> values = new ArrayList<>(); // Doesn't compile, because of incompatible types
        values.add(1);
        values.add(8);
        values.add(8);
        values.add("2");
        var expectedResult = 17;
        Calculator calculator = new Calculator(values);

        // when
        int result = calculator.add();

        // then
        assertEquals(expectedResult, result);
    }
}
