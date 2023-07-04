package com.github.marcinciapa.chapter5.problem111;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ComputeTest {

    private static final Map<String, Integer> MAP = Map.of(
      "a", 1,
      "b", 2,
      "c", 3
    );

    @Test
    void shouldIncrementValueIfPresent() {
        // given
        Compute compute = new Compute(MAP);

        // when
        int firstValue = compute.incrementAndGet("a");
        int secondValue = compute.incrementAndGet("a");

        // then
        assertEquals(2, firstValue);
        assertEquals(3, secondValue);
    }

    @Test
    void shouldSetValueIfNotPresent() {
        // given
        Compute compute = new Compute(MAP);

        // when
        int firstValue = compute.incrementAndGet("d");
        int secondValue = compute.incrementAndGet("d");

        // then
        assertEquals(0, firstValue);
        assertEquals(1, secondValue);
    }
}
