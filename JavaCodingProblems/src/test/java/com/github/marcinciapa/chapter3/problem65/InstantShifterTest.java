package com.github.marcinciapa.chapter3.problem65;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZonedDateTime;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class InstantShifterTest<T extends InstantShifter> {

    abstract T shifter(Instant initialInstant);

    @Test
    void shouldAddDays() {
        // given
        Instant initialInstant = Instant.from(ZonedDateTime.of(2023, 4, 15, 12, 7, 33, 444, UTC));
        Instant expectedInstant = Instant.from(ZonedDateTime.of(2023, 4, 17, 12, 7, 33, 444, UTC));
        T shifter = shifter(initialInstant);

        // when
        Instant result = shifter.addDays(2);

        // then
        assertEquals(expectedInstant, result);
    }

    @Test
    void shouldSubtractHours() {
        // given
        Instant initialInstant = Instant.from(ZonedDateTime.of(2023, 4, 15, 12, 7, 33, 444, UTC));
        Instant expectedInstant = Instant.from(ZonedDateTime.of(2023, 4, 15, 10, 7, 33, 444, UTC));
        T shifter = shifter(initialInstant);

        // when
        Instant result = shifter.minusHours(2);

        // then
        assertEquals(expectedInstant, result);
    }
}
