package com.github.marcinciapa.chapter5.problem115;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class MapValueSorterTest<T extends MapValueSorter> {

    private static final Map<DigitalNumber, WrittenNumber> UNSORTED_MAP = Map.of(
            new DigitalNumber(5), new WrittenNumber("five"),
            new DigitalNumber(4), new WrittenNumber("four"),
            new DigitalNumber(3), new WrittenNumber("three"),
            new DigitalNumber(2), new WrittenNumber("two"),
            new DigitalNumber(1), new WrittenNumber("one")
    );
    private static final WrittenNumber[] SORTED_VALUES = new WrittenNumber[]{
            new WrittenNumber("five"),
            new WrittenNumber("four"),
            new WrittenNumber("one"),
            new WrittenNumber("three"),
            new WrittenNumber("two")
    };

    abstract T sorter();

    @Test
    void shouldSortMap() {
        // when
        Map<DigitalNumber, WrittenNumber> sortedMap = sorter().sortedByValue(UNSORTED_MAP);
        assertEquals(UNSORTED_MAP, sortedMap);
        assertArrayEquals(SORTED_VALUES, sortedMap.values().toArray());
    }
}
