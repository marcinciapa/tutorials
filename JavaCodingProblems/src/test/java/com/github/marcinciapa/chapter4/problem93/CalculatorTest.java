package com.github.marcinciapa.chapter4.problem93;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddNumbers() {
        // given
        var numbers = List.of(2, 5, 7);
        var expectedResult = 14;
        var numbersProvider = new NumbersProvider() {
            @Override
            public Collection<Integer> provideNumbers() {
                return numbers;
            }
        };
        var numbersAdder = new NumbersAdder(numbersProvider);

        // when
        int result = numbersAdder.add();

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnZeroWhenNumbersEmpty() {
        // given
        var numbersProvider = new NumbersProvider() {
            @Override
            public Collection<Integer> provideNumbers() {
                return emptyList();
            }
        };
        var numbersAdder = new NumbersAdder(numbersProvider);

        // when
        int result = numbersAdder.add();

        // then
        assertEquals(0, result);
    }

    @Test
    void shouldThrowExceptionWhenProviderNull() {
        assertThrows(IllegalArgumentException.class, () -> new NumbersAdder(null));
    }

    @Test
    void shouldThrowExceptionWhenProviderProvidesNull() {
        var numbersProvider = new NumbersProvider() {
            @Override
            public Collection<Integer> provideNumbers() {
                return null;
            }
        };

        assertThrows(IllegalArgumentException.class, () -> new NumbersAdder(numbersProvider));
    }

}
