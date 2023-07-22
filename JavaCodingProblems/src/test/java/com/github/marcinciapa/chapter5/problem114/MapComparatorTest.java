package com.github.marcinciapa.chapter5.problem114;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapComparatorTest {

    @Test
    void shouldReturnTrueIfMapsEqual() {
        // given
        Map<String, String> map1 = Map.of(
                "one", "1",
                "two", "2",
                "three", "3"
        );
        Map<String, String> map2 = Map.of(
                "three", "3",
                "two", "2",
                "one", "1"
        );

        // then
        assertEquals(map1, map2);
    }

    @Test
    void shouldReturnFalseIfKeysNotEqual() {
        Map<String, String> map1 = Map.of(
                "one", "1",
                "two", "2",
                "three", "3"
        );
        Map<String, String> map2 = Map.of(
                "one", "1",
                "two", "2",
                "four", "3"
        );

        // then
        assertNotEquals(map1, map2);
    }

    @Test
    void shouldReturnFalseIfValuesNotEqual() {
        Map<String, String> map1 = Map.of(
                "one", "1",
                "two", "2",
                "three", "3"
        );
        Map<String, String> map2 = Map.of(
                "one", "1",
                "two", "2",
                "three", "4"
        );

        // then
        assertNotEquals(map1, map2);
    }

    @Test
    void shouldReturnFalseIfValuesReplaced() {
        Map<String, String> map1 = Map.of(
                "one", "1",
                "two", "2",
                "three", "3"
        );
        Map<String, String> map2 = Map.of(
                "one", "1",
                "two", "3",
                "three", "2"
        );

        // then
        assertNotEquals(map1, map2);
    }

    @Test
    void shouldReturnFalseIfSizeDifferent() {
        Map<String, String> map1 = Map.of(
                "one", "1",
                "two", "2",
                "three", "3"
        );
        Map<String, String> map2 = Map.of(
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4"
        );

        // then
        assertNotEquals(map1, map2);
    }
}
