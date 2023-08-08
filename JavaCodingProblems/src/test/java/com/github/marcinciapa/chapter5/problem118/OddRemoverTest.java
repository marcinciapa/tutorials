package com.github.marcinciapa.chapter5.problem118;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class OddRemoverTest<T extends OddRemover> {

    abstract T oddRemover();

    @Test
    void shouldFailWhenNullPassed() {
        T oddRemover = oddRemover();
        assertThrows(IllegalArgumentException.class, () -> oddRemover.removeOdd(null));
    }

    @Test
    void shouldKeepListUnchangedWhenEmptyListPassed() {
        // given
        List<Integer> input = new ArrayList<>(emptyList());
        T oddRemover = oddRemover();

        // when
        oddRemover.removeOdd(input);

        // then
        assertEquals(emptyList(), input);
    }

    @Test
    void shouldRemoveAllElementsWhenOnlyOddsPassed() {
        // given
        List<Integer> input = new ArrayList<>(List.of(1, 3, 5));
        T oddRemover = oddRemover();

        // when
        oddRemover.removeOdd(input);

        // then
        assertEquals(emptyList(), input);
    }

    @Test
    void shouldKeepListUnchangedWhenOnlyEvensPassed() {
        // given
        List<Integer> input = new ArrayList<>(List.of(2, 4, 6));
        List<Integer> expectedResult = List.of(2, 4, 6);
        T oddRemover = oddRemover();

        // when
        oddRemover.removeOdd(input);

        // then
        assertEquals(expectedResult, input);
    }

    @Test
    void shouldRemoveOddsAndKeepEvens() {
        // given
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> expectedResult = List.of(2, 4, 6);
        T oddRemover = oddRemover();

        // when
        oddRemover.removeOdd(input);

        // then
        assertEquals(expectedResult, input);
    }
}
