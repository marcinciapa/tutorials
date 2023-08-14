package com.github.marcinciapa.chapter5.problem121;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

abstract class OddReplacerTest<T extends OddReplacer> {

    abstract T oddReplacer();

    @Test
    void shouldFailWhenNullPassed() {
        assertThrows(IllegalArgumentException.class, () -> oddReplacer().replaceOdd(null));
    }

    @Test
    void shouldKeepEmptyCollectionWhenEmptyPassed() {
        // given
        ArrayList<Integer> emptyNumbers = new ArrayList<>();

        // when
        oddReplacer().replaceOdd(emptyNumbers);

        // then
        assertTrue(emptyNumbers.isEmpty());
    }

    @Test
    void shouldNotReplaceAnyElementWhenCollectionOfEvensPassed() {
        // given
        ArrayList<Integer> evenNumbers = new ArrayList<>(List.of(2, 4, 6));
        List<Integer> expectedResult = List.of(2, 4, 6);

        // when
        oddReplacer().replaceOdd(evenNumbers);

        // then
        assertEquals(expectedResult, evenNumbers);
    }

    @Test
    void shouldReplaceAllElementsWhenCollectionOfOddsPassed() {
        // given
        ArrayList<Integer> oddNumbers = new ArrayList<>(List.of(1, 3, 5));
        List<Integer> expectedResult = List.of(0, 0, 0);

        // when
        oddReplacer().replaceOdd(oddNumbers);

        // then
        assertEquals(expectedResult, oddNumbers);
    }

    @Test
    void shouldReplaceOddsWhenMixedCollectionPassed() {
        // given
        ArrayList<Integer> mixedNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> expectedResult = List.of(0, 2, 0, 4, 0, 6);

        // when
        oddReplacer().replaceOdd(mixedNumbers);

        // then
        assertEquals(expectedResult, mixedNumbers);
    }
}
