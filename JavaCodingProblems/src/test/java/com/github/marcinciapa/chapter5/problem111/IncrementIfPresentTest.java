package com.github.marcinciapa.chapter5.problem111;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncrementIfPresentTest {

    private static final Map<String, Integer> INITIAL_MAP = Map.of(
            "a", 1,
            "b", 2,
            "c", 3
    );
    private final IncrementIfPresent incrementer = new IncrementIfPresent(INITIAL_MAP);

    @Test
    void shouldIncrementValueInMapIfPresent() {
        // given
        Map<String, Integer> expectedResult = Map.of(
                "a", 2,
                "b", 2,
                "c", 3
        );

        // when
        incrementer.incrementIfPresent("a");

        // then
        assertEquals(expectedResult, incrementer.map());
    }

    @Test
    void shouldNotChangeMapIfNotPresent() {
        // when
        incrementer.incrementIfPresent("d");

        // then
        assertEquals(INITIAL_MAP, incrementer.map());
    }
}
