package com.github.marcinciapa.chapter5.problem118;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamOddRemoverTest {

    @Test
    void shouldRemoveOddElements() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> expectedResult = List.of(2, 4, 6);
        StreamOddRemover oddRemover = new StreamOddRemover();

        // when
        List<Integer> result = oddRemover.removeOdd(numbers);

        // then
        assertEquals(expectedResult, result);
    }
}
