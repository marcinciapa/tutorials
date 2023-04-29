package com.github.marcinciapa.chapter3.problem73;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

abstract class DateRangeIteratorTest<T extends DateRangeIterator> {

    abstract T iterator(DayOfYear rangeStart, DayOfYear rangeEnd);

    @ParameterizedTest
    @MethodSource("nullRangeInput")
    void shouldFailWhenArgumentNull(DayOfYear rangeStart, DayOfYear rangeEnd) {
        assertThrows(IllegalArgumentException.class, () -> iterator(rangeStart, rangeEnd));
    }

    @Test
    void shouldFailWhenRangeEndBeforeStart() {
        DayOfYear rangeStart = new DayOfYear(2023, 4, 29);
        DayOfYear rangeEnd = new DayOfYear(2023, 4, 28);
        assertThrows(IllegalArgumentException.class, () -> iterator(rangeStart, rangeEnd));
    }

    @Test
    void shouldReturnEmptyWhenRangeStartEndEqual() {
        // given
        DayOfYear rangeStart = new DayOfYear(2023, 4, 29);
        DayOfYear rangeEnd = new DayOfYear(2023, 4, 29);

        // when
        Iterator<DayOfYear> result = iterator(rangeStart, rangeEnd).iterate();

        // then
        assertFalse(result.hasNext());
    }

    @Test
    void shouldReturnNonEmptyRangeExclusiveRight() {
        // given
        DayOfYear rangeStart = new DayOfYear(2023, 4, 27);
        DayOfYear rangeEnd = new DayOfYear(2023, 4, 30);

        // when
        Iterator<DayOfYear> result = iterator(rangeStart, rangeEnd).iterate();

        // then
        assertEquals(new DayOfYear(2023, 4, 27), result.next());
        assertEquals(new DayOfYear(2023, 4, 28), result.next());
        assertEquals(new DayOfYear(2023, 4, 29), result.next());
        assertFalse(result.hasNext());
    }

    static Stream<Arguments> nullRangeInput() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new DayOfYear(2023, 4, 29), null),
                Arguments.of(null, new DayOfYear(2023, 4, 29))
        );
    }
}
