package com.github.marcinciapa.chapter4.problem97;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdderTest {

    @Test
    void shouldSumElements() {
        // given
        var numbers = List.of(5, 3, 1);
        var expectedResult = 9;
        var adder = new Adder<>(numbers);

        // when
        var result = adder.sum();

        // then
        assertEquals(expectedResult, result);
    }
}
