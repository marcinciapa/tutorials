package com.github.marcinciapa.chapter3.problem69;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class TimestampToTimeConverterTest<T extends TimestampToTimeConverter<U>, U> {

    abstract T converter();

    abstract U expected(Instant instant);

    @Test
    void shouldConvertTimestampToDate() {
        // given
        Instant now = Instant.now();
        U expected = expected(now);

        // when
        U result = converter().convert(now.toEpochMilli());

        // then
        assertEquals(expected, result);
    }
}
