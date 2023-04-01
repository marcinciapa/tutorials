package com.github.marcinciapa.chapter3.problem58;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class DateTimeConverterTest<T extends DateTimeConverter> {

    abstract T createInstance();

    @Test
    void shouldFailWhenIllegalArgument() {
        T converter = createInstance();
        assertThrows(IllegalArgumentException.class, () -> converter.toCetDateTime(null));
    }

    @Test
    void shouldFailWhenIncorrectFormat() {
        T converter = createInstance();
        assertThrows(DateTimeException.class, () -> converter.toCetDateTime("abc"));
    }

    @Test
    void shouldConvertToCet() {
        // given
        String utcDateTime = "2023-03-31T15:02:00";
        T converter = createInstance();

        // when
        String result = converter.toCetDateTime(utcDateTime);
        assertEquals("2023-03-31T17:02:00 CEST", result);
    }
}
