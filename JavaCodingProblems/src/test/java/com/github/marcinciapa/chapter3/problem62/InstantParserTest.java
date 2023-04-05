package com.github.marcinciapa.chapter3.problem62;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZonedDateTime;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class InstantParserTest<T extends InstantParser> {

    abstract T instantParser();

    @Test
    void shouldFailWhenArgumentNull() {
        assertThrows(IllegalArgumentException.class, () -> instantParser().toInstant(null));
    }

    @Test
    void shouldFailWhenArgumentHasIncorrectFormat() {
        assertThrows(IllegalArgumentException.class, () -> instantParser().toInstant("Incorrect format"));
    }

    @Test
    void shouldParseInstant() {
        // given
        Instant expected = Instant.from(ZonedDateTime.of(2023, 4, 5, 18, 39, 33, 0, UTC));
        String utcString = "2023-04-05T18:39:33Z";

        // when
        Instant result = instantParser().toInstant(utcString);

        // then
        assertEquals(expected, result);
    }

    @Test
    void shouldFailWhenDateNotExisting() {
        assertThrows(IllegalArgumentException.class, () -> instantParser().toInstant("2023-02-29T23:59:59Z"));
    }
}
