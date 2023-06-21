package com.github.marcinciapa.chapter5.problem107;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class NgeFinderTest<T extends NgeFinder> {

    abstract T ngeFinder();

    @Test
    void shouldFailWhenArrayNull() {
        assertThrows(IllegalArgumentException.class, () -> ngeFinder().ngeIndex(null));
    }

    @ParameterizedTest
    @MethodSource("input")
    void shouldReturnNge(int[] array, Collection<ElementWithNge> elementsWithNge) {
        // given
        T ngeFinder = ngeFinder();

        // when
        Collection<ElementWithNge> result = ngeFinder.ngeIndex(array);

        // then
        assertEquals(elementsWithNge, result);
    }

    static Stream<Arguments> input() {
        return Stream.of(
                Arguments.of(new int[0], emptyList()),
                Arguments.of(new int[]{1}, List.of(
                        new ElementWithNge(1, OptionalInt.empty())
                )),
                Arguments.of(new int[]{3, 2, 1}, List.of(
                        new ElementWithNge(3, OptionalInt.empty()),
                        new ElementWithNge(2, OptionalInt.empty()),
                        new ElementWithNge(1, OptionalInt.empty())
                )),
                Arguments.of(new int[]{1, 2, 3, 2, 3, 5, 4}, List.of(
                        new ElementWithNge(1, OptionalInt.of(2)),
                        new ElementWithNge(2, OptionalInt.of(3)),
                        new ElementWithNge(3, OptionalInt.of(5)),
                        new ElementWithNge(2, OptionalInt.of(3)),
                        new ElementWithNge(3, OptionalInt.of(5)),
                        new ElementWithNge(5, OptionalInt.empty()),
                        new ElementWithNge(4, OptionalInt.empty())
                ))
        );
    }
}
