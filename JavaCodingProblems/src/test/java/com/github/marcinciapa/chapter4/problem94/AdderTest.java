package com.github.marcinciapa.chapter4.problem94;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdderTest {

    @Test
    void shouldSumNumbers() {
        // given
        var numbers = List.of(2, 5, 9); // effectively final
        final var expectedResult = 16;
        final var numbersProvider = new NumbersProvider() {
            @Override
            public Collection<Integer> provide() {
                return numbers;
            }
        };
        final var adder = new Adder(numbersProvider);
        // numbers = List.of(5, 8, 7, 1); // Does not compile, numbers must be effectively final

        // when
        final var result = adder.sum();

        // then
        assertEquals(expectedResult, result);
    }
}
