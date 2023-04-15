package com.github.marcinciapa.chapter3.problem65;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

abstract class LocalDateTimeShifterTest<T extends LocalDateTimeShifter> {

    abstract T shifter(LocalDateTime date);

    @Test
    void shouldAddDays() {
        // given
        LocalDateTime initialDate = LocalDateTime.of(2023, 4, 15, 11, 56, 33);
        LocalDateTime expectedDate = LocalDateTime.of(2023, 4, 17, 11, 56, 33);
        T shifter = shifter(initialDate);

        // when
        LocalDateTime result = shifter.addDays(2);

        // then
        assertEquals(expectedDate, result);
    }

    @Test
    void shouldSubractHours() {
        // given
        LocalDateTime initialDate = LocalDateTime.of(2023, 4, 15, 11, 56, 33);
        LocalDateTime expectedDate = LocalDateTime.of(2023, 4, 15, 9, 56, 33);
        T shifter = shifter(initialDate);

        // when
        LocalDateTime result = shifter.subtractHours(2);

        // then
        assertEquals(expectedDate, result);
    }
}
