package com.github.marcinciapa.chapter3.problem74;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class AgeCalculatorTest<T extends AgeCalculator> {

    abstract T calculator(Instant dateOfBirth, Clock clock);

    @Test
    void shouldReturn0WhenBirthDateInTheFuture() {
        // given
        Instant dateOfBirth = LocalDateTime.of(2023, 10, 27, 8, 53).toInstant(UTC);
        Instant now = LocalDateTime.of(2023, 5, 1, 8, 45).toInstant(UTC);
        int expectedAge = 0;
        Clock clock = Clock.fixed(now, UTC);
        T calculator = calculator(dateOfBirth, clock);

        // when
        int result = calculator.calculateAge();

        // then
        assertEquals(expectedAge, result);
    }

    @Test
    void shouldReturnAgeWhenBirthDateInThePastLaterInYear() {
        // given
        Instant dateOfBirth = LocalDateTime.of(1988, 10, 27, 8, 53).toInstant(UTC);
        Instant now = LocalDateTime.of(2023, 5, 1, 8, 45).toInstant(UTC);
        int expectedAge = 34;
        Clock clock = Clock.fixed(now, UTC);
        T calculator = calculator(dateOfBirth, clock);

        // when
        int result = calculator.calculateAge();

        // then
        assertEquals(expectedAge, result);
    }

    @Test
    void shouldReturnAgeWhenBirthDateInThePastEarlierInYear() {
        // given
        Instant dateOfBirth = LocalDateTime.of(1988, 3, 29, 8, 53).toInstant(UTC);
        Instant now = LocalDateTime.of(2023, 5, 1, 8, 45).toInstant(UTC);
        int expectedAge = 35;
        Clock clock = Clock.fixed(now, UTC);
        T calculator = calculator(dateOfBirth, clock);

        // when
        int result = calculator.calculateAge();

        // then
        assertEquals(expectedAge, result);
    }
}
