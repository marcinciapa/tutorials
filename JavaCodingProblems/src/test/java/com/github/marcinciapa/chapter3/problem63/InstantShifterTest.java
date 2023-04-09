package com.github.marcinciapa.chapter3.problem63;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.time.Period;
import java.util.stream.Stream;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class InstantShifterTest<T extends InstantShifter> {

    abstract T shifter();

    @ParameterizedTest
    @MethodSource("incorrectInput")
    void shouldFailWhenArgumentIncorrect(Instant instant, Period period) {
        assertThrows(IllegalArgumentException.class, () -> shifter().after(instant, period));
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


    static Stream<Arguments> incorrectInput() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, Period.ofDays(1)),
                Arguments.of(now(), null)
        );
    }
}
