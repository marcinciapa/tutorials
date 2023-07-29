package com.github.marcinciapa.chapter5.problem115;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class MapSorterTest<T extends MapSorter> {

    private static final Map<AlphabetChar, Character> UNSORTED_MAP = Map.of(
            new AlphabetChar('a', 1), 'a',
            new AlphabetChar('b', 2), 'b',
            new AlphabetChar('c', 3), 'c',
            new AlphabetChar('d', 4), 'd',
            new AlphabetChar('e', 5), 'e'
    );
    private static final AlphabetChar[] SORTED_KEYS = new AlphabetChar[]{
            new AlphabetChar('a', 1),
            new AlphabetChar('b', 2),
            new AlphabetChar('c', 3),
            new AlphabetChar('d', 4),
            new AlphabetChar('e', 5)
    };

    abstract T sorter();

    @Test
    void shouldSortMap() {
        // when
        Map<AlphabetChar, Character> sortedMap = sorter().sorted(UNSORTED_MAP);
        assertEquals(UNSORTED_MAP, sortedMap);
        assertArrayEquals(SORTED_KEYS, sortedMap.keySet().toArray());
    }
}
