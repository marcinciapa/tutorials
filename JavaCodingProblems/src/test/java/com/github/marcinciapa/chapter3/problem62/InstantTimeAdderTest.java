package com.github.marcinciapa.chapter3.problem62;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class InstantTimeAdderTest<T extends InstantTimeAdder> {

    abstract T timeAdder(Instant initialInstant);

    @Test
    void shouldFailWhenArgumentIncorrect() {
        InstantTimeAdder timeAdder = timeAdder(now());
        assertThrows(IllegalArgumentException.class, () -> timeAdder.add(null));
    }

    @Test
    void shouldReturnSameInstantWhenAddingZero() {
        // given
        Instant initialInstant = Instant.ofEpochSecond(42);
        T timeAdder = timeAdder(initialInstant);

        // when
        Instant result = timeAdder.add(Duration.ZERO);

        // then
        assertEquals(initialInstant, result);
    }

    @Test
    void shouldReturnValueWhenAddingDuration() {
        // given
        Instant initialInstant = Instant.ofEpochSecond(42);
        T timeAdder = timeAdder(initialInstant);
        Instant expectedResult = Instant.ofEpochSecond(43);

        // when
        Instant result = timeAdder.add(Duration.ofSeconds(1));

        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldReturnValueWhenSubtractingDuration() {
        // given
        Instant initialInstant = Instant.ofEpochSecond(42);
        T timeAdder = timeAdder(initialInstant);
        Instant expectedResult = Instant.ofEpochSecond(41);

        // when
        Instant result = timeAdder.add(Duration.ofSeconds(-1));

        // then
        assertEquals(expectedResult, result);
    }
}
