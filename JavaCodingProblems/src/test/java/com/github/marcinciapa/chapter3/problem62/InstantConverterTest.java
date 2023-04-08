package com.github.marcinciapa.chapter3.problem62;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class InstantConverterTest<T extends InstantConverter> {

    abstract T converter();

    @Nested
    class ToCet {

        @Test
        void shouldFailWhenArgumentIncorrect() {
            assertThrows(IllegalArgumentException.class, () -> converter().toCet(null));
        }

        @Test
        void shouldConvertToCet() {
            // given
            ZonedDateTime expected = ZonedDateTime.of(2023, 4, 8, 10, 49, 21, 0, ZoneId.of("CET"));
            long timestamp = expected.toEpochSecond();
            Instant instant = Instant.ofEpochSecond(timestamp);

            // when
            ZonedDateTime result = converter().toCet(instant);

            // then
            assertEquals(expected, result);
        }
    }

    @Nested
    class FromCet {

        @Test
        void shouldFailWhenArgumentIncorrect() {
            assertThrows(IllegalArgumentException.class, () -> converter().toCet(null));

        }

        @Test
        void shouldConvertToInstant() {
            // given
            ZonedDateTime cet = ZonedDateTime.of(2023, 4, 8, 10, 45, 41, 0, ZoneId.of("CET"));
            long cetTimestamp = cet.toEpochSecond();
            Instant expected = Instant.ofEpochSecond(cetTimestamp);

            // when
            Instant result = converter().fromCet(cet);

            // then
            assertEquals(expected, result);
        }
    }
}
