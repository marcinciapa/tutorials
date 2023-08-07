package com.github.marcinciapa.chapter5.problem117;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MapMergerTest {

    private static final Map<String, Integer> LEFT_MAP = Map.of(
            "one", 1,
            "two", 2,
            "three", 3
    );

    private static final Map<String, Integer> RIGHT_MAP = Map.of(
            "three", 4,
            "four", 5,
            "five", 6
    );

    private static final Map<String, Integer> MERGED_MAP = Map.of(
            "one", 1,
            "two", 2,
            "three", 4,
            "four", 5,
            "five", 6
    );

    private final MapMerger merger = new MapMerger();

    @Test
    void shouldTakeLeftMapWhenRightEmpty() {
        // when
        Map<String, Integer> result = merger.merge(LEFT_MAP, emptyMap());

        // then
        assertEquals(LEFT_MAP, result);
    }

    @Test
    void shouldTakeRightMapWhenLeftEmpty() {
        // when
        Map<String, Integer> result = merger.merge(emptyMap(), RIGHT_MAP);

        // then
        assertEquals(RIGHT_MAP, result);
    }

    @Test
    void shouldMergeMapsWithFavorOfRightMapWhenConflict() {
        // when
        Map<String, Integer> result = merger.merge(LEFT_MAP, RIGHT_MAP);

        // then
        assertEquals(MERGED_MAP, result);
    }

    @Test
    void shouldFailWhenLeftMapNull() {
        assertThrows(IllegalArgumentException.class, () -> merger.merge(null, RIGHT_MAP));
    }

    @Test
    void shouldFailWhenRightMapNull() {
        assertThrows(IllegalArgumentException.class, () -> merger.merge(LEFT_MAP, null));
    }

    @Test
    void shouldFailWhenBothMapsNull() {
        assertThrows(IllegalArgumentException.class, () -> merger.merge(null, null));
    }
}
