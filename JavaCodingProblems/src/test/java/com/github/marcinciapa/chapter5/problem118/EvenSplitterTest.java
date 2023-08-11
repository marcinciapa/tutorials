package com.github.marcinciapa.chapter5.problem118;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenSplitterTest {

    private static final List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
    private static final List<Integer> resultEven = List.of(2, 4, 6);
    private static final List<Integer> resultOdd = List.of(1, 3, 5);

    private final EvenSplitter evenSplitter = new EvenSplitter();

    @Test
    void shouldSeparateEvensAndOdds() {
        // when
        Map<Boolean, List<Integer>> result = evenSplitter.splitEvensFromOdds(input);

        // then
        assertEquals(resultEven, result.get(true));
        assertEquals(resultOdd, result.get(false));
    }
}
