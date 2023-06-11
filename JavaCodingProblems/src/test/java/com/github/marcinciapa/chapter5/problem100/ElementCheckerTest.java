package com.github.marcinciapa.chapter5.problem100;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

abstract class ElementCheckerTest<T extends ElementChecker> {

    abstract T checker();

    private final Comparator<IntWrapper> comparator = Comparator.comparingInt(o -> o.i);

    @Test
    void shouldFailWhenArrayNull() {
        T checker = checker();
        assertThrows(IllegalArgumentException.class, () -> checker.contains(new IntWrapper(0), null, comparator));
    }

    @Test
    void shouldFailWhenComparatorNull() {
        T checker = checker();
        IntWrapper[] array = new IntWrapper[]{
                new IntWrapper(0),
                new IntWrapper(1),
                new IntWrapper(2)
        };
        IntWrapper element = new IntWrapper(1);

        assertThrows(IllegalArgumentException.class, () -> checker.contains(element, array, null));
    }

    @Test
    void shouldReturnFalseIfNotFoundInEmptyArray() {
        // given
        IntWrapper[] array = new IntWrapper[]{};
        IntWrapper element = new IntWrapper(1);

        // when
        boolean elementFound = checker().contains(element, array, comparator);

        // then
        assertFalse(elementFound);
    }

    @Test
    void shouldReturnFalseIfNotFoundInNonEmptyArray() {
        // given
        IntWrapper[] array = new IntWrapper[]{
                new IntWrapper(0),
                new IntWrapper(2)
        };
        IntWrapper element = new IntWrapper(1);

        // when
        boolean elementFound = checker().contains(element, array, comparator);

        // then
        assertFalse(elementFound);
    }

    @Test
    void shouldReturnTrueIfFoundInArray() {
        // given
        IntWrapper[] array = new IntWrapper[]{
                new IntWrapper(0),
                new IntWrapper(1),
                new IntWrapper(2)
        };
        IntWrapper element = new IntWrapper(1);

        // when
        boolean elementFound = checker().contains(element, array, comparator);

        // then
        assertTrue(elementFound);
    }
}
