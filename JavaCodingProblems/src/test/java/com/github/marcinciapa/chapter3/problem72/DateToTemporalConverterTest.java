package com.github.marcinciapa.chapter3.problem72;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import static java.time.ZoneId.of;
import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class DateToTemporalConverterTest<T extends DateToTemporalConverter> {

    abstract T converter(Date date);

    @Test
    void shouldFailWhenCreatedWithNullDate() {
        assertThrows(IllegalArgumentException.class, () -> converter(null));
    }

    @Test
    void shouldConvertToInstant() {
        // given
        Instant instant = Instant.ofEpochMilli(123456L);
        Date date = Date.from(instant);

        // when
        Instant result = converter(date).toInstant();

        // then
        assertEquals(instant, result);
    }

    @Test
    void shouldConvertToLocalDateTime() {
        // given
        Instant instant = Instant.ofEpochMilli(123456L);
        Date date = Date.from(instant);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, UTC);

        // when
        LocalDateTime result = converter(date).toLocalDateTime();

        // then
        assertEquals(localDateTime, result);
    }

    @Test
    void shouldConvertToZonedDateTime() {
        // given
        Instant instant = Instant.ofEpochMilli(123456L);
        Date date = Date.from(instant);
        ZonedDateTime cest = ZonedDateTime.ofInstant(instant, of("CET"));

        // when
        ZonedDateTime result = converter(date).toZonedDateTime(of("CET"));

        // then
        assertEquals(cest, result);
    }

    @Test
    void shouldConvertToLocalDate() {
        // given
        Instant instant = Instant.ofEpochMilli(1234888856L);
        Date date = Date.from(instant);
        LocalDate localDate = LocalDate.ofInstant(instant, UTC);

        // when
        LocalDate result = converter(date).toLocalDate();

        // then
        assertEquals(localDate, result);
    }
}
