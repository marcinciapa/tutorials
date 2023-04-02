package com.github.marcinciapa.chapter3.problem59;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class DateTimeFormatterTest<T extends DateTimeFormatter> {

    abstract T createInstance();

    @Test
    void shouldFailWhenArgumentInvalid() {
        T formatter = createInstance();
        assertThrows(IllegalArgumentException.class, () -> formatter.format(null));
    }

    @Test
    void shouldFormatDateTimeRoundingHighSecondsDown() {
        // given
        T formatter = createInstance();
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.APRIL, 2, 17, 40, 59);

        // when
        String result = formatter.format(dateTime);

        // then
        assertEquals("2023-04-02T17:40", result);
    }
}
