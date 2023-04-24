package com.github.marcinciapa.chapter3.problem70;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class FirstLastDayOfMonthFinderTest<T extends FirstLastDayOfMonthFinder> {

    abstract T finder(LocalDateTime date);

    @Test
    void shouldFindFirstDayOfMonth() {
        // given
        LocalDateTime dateTime = LocalDateTime.of(2023, 4, 24, 20, 27, 15);
        LocalDate expected = LocalDate.of(2023, 4, 1);
        T finder = finder(dateTime);

        // when
        LocalDate result = finder.firstDayOfMonth();

        // then
        assertEquals(expected, result);
    }

    @Test
    void shouldFindLastDayOfMonth() {
        // given
        LocalDateTime dateTime = LocalDateTime.of(2023, 4, 24, 20, 27, 15);
        LocalDate expected = LocalDate.of(2023, 4, 30);
        T finder = finder(dateTime);

        // when
        LocalDate result = finder.lastDayOfMonth();

        // then
        assertEquals(expected, result);
    }

}
