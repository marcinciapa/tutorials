package com.github.marcinciapa.chapter4.problem90;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncrementerTest {

    @Test
    void shouldIncrementElements() {
        // given
        var input = List.of(1, 2, 3);
        var expectedOutput = List.of(2, 3, 4);
        Incrementer incrementer = new Incrementer(input);

        // when
        var output = incrementer.increment();

        // then
        assertEquals(expectedOutput, output);
    }
}
