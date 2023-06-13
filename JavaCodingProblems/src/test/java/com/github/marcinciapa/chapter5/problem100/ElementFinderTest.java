package com.github.marcinciapa.chapter5.problem100;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

abstract class ElementFinderTest<T extends ElementFinder> {

    abstract T finder();

    @Test
    void shouldFailWhenArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> finder().firstIndexOf(1, null));
    }

    @Test
    void shouldReturnEmptyIfNotFoundInEmptyArray() {
        // given
        T finder = finder();

        // when
        Optional<Integer> result = finder.firstIndexOf(5, new int[]{});

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyIfNotFoundInNonEmptyArray() {
        // given
        T finder = finder();
        int[] array = new int[]{1, 2, 3};

        // when
        Optional<Integer> result = finder.firstIndexOf(4, array);

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnIndexIfFoundInArray() {
        // given
        T finder = finder();
        int[] array = new int[]{1, 2, 2, 3, 2};

        // when
        Optional<Integer> result = finder.firstIndexOf(2, array);

        // then
        assertTrue(result.isPresent());
        assertEquals(1, result.get());
    }
}
