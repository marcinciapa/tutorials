package com.github.marcinciapa.chapter5.problem116;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapClonerTest {

    private final MapCloner mapCloner = new MapCloner();

    @Test
    void shouldFailWhenNullPassed() {
        assertThrows(IllegalArgumentException.class, () -> mapCloner.clone(null));
    }

    @Test
    void shouldCloneMap() {
        // given
        HashMap<Integer, String> sourceMap = new HashMap<>();
        sourceMap.put(1, "one");
        sourceMap.put(2, "two");
        sourceMap.put(3, "three");
        sourceMap.put(4, "four");

        // when
        Map<Integer, String> clonedMap = mapCloner.clone(sourceMap);

        // then
        assertEquals(sourceMap, clonedMap);
        sourceMap.put(5, "five");
        assertNotEquals(sourceMap, clonedMap);
    }
}
