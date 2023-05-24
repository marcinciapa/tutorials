package com.github.marcinciapa.chapter4.problem91;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenIncrementerTest {

    @Test
    void shouldIncrementEven() {
        // given
        var input = List.of(1, 3, 4, 2, 7);
        var incrementer = new EvenIncrementer(input);
        var expectedOutput = List.of(5, 3);

        // when
        List<Integer> output = incrementer.incrementEven();

        // then
        assertEquals(expectedOutput, output);
    }
}
