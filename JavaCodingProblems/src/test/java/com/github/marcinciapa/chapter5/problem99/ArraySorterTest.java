package com.github.marcinciapa.chapter5.problem99;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class ArraySorterTest<T extends ArraySorter> {

    abstract ArraySorter sorter();

    @Test
    void shouldFailIfArrayNull() {
        assertThrows(IllegalArgumentException.class, () -> sorter().sort(null));
    }

    @Test
    void shouldSortEmptyArray() {
        // given
        var input = new Integer[]{};
        var expectedResult = new Integer[]{};

        // when
        Integer[] result = sorter().sort(input);

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldSortOneElementArray() {
        // given
        var input = new Integer[]{4};
        var expectedResult = new Integer[]{4};

        // when
        Integer[] result = sorter().sort(input);

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldSortSortedArray() {
        // given
        var input = new Integer[]{1, 2, 3, 4};
        var expectedResult = new Integer[]{1, 2, 3, 4};

        // when
        Integer[] result = sorter().sort(input);

        // then
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldSortUnsortedArray() {
        // given
        var input = new Integer[]{4, 1, 3, 2, 8, 8, 12, 54};
        var expectedResult = new Integer[]{1, 2, 3, 4, 8, 8, 12, 54};

        // when
        Integer[] result = sorter().sort(input);

        // then
        assertArrayEquals(expectedResult, result);
    }
}
