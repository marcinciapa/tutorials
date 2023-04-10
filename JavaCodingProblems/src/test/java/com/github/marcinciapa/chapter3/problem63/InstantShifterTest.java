package com.github.marcinciapa.chapter3.problem63;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.util.stream.Stream;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class InstantShifterTest<T extends InstantShifter> {

    abstract T shifter();

    @ParameterizedTest
    @MethodSource("incorrectInputPeriod")
    void shouldPeriodShiftFailWhenArgumentIncorrect(Instant instant, Period period) {
        assertThrows(IllegalArgumentException.class, () -> shifter().after(instant, period));
    }

    static Stream<Arguments> incorrectInputPeriod() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, Period.ofDays(1)),
                Arguments.of(now(), null)
        );
    }

    @Test
    void shouldShiftInstantWithPeriod() {
        // given
        T instantShifter = shifter();
        Instant now = now();

        // when
        Instant result = instantShifter.after(now, Period.ofDays(2));

        // then
        assertTrue(result.isAfter(now));
    }

    @ParameterizedTest
    @MethodSource("incorrectInputDuration")
    void shouldDurationShiftFailWhenArgumentIncorrect(Instant instant, Duration duration) {
        assertThrows(IllegalArgumentException.class, () -> shifter().after(instant, duration));
    }

    static Stream<Arguments> incorrectInputDuration() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, Duration.ofSeconds(1)),
                Arguments.of(now(), null)
        );
    }

    @Test
    void shouldShiftInstantWithDuration() {
        // given
        T instantShifter = shifter();
        Instant now = now();

        // when
        Instant result = instantShifter.after(now, Duration.ofSeconds(1));

        // then
        assertTrue(result.isAfter(now));
    }
}
