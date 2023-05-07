package com.github.marcinciapa.chapter3.problem76;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

abstract class TimeDifferenceCalculatorTest<T extends TimeDifferenceCalculator> {

    abstract T calculator(Instant time1, Instant time2);

    @Test
    void shouldReturn0WhenDatesEqual() {
        // given
        Instant time1 = LocalDateTime.of(2023, 5, 7, 9, 30).toInstant(UTC);
        Instant time2 = LocalDateTime.of(2023, 5, 7, 9, 30).toInstant(UTC);
        long expectedDifferenceSeconds = 0;

        // when
        long result = calculator(time1, time2).secondsBetween();

        // then
        assertEquals(expectedDifferenceSeconds, result);
    }

    @Test
    void shouldReturnPositiveValueWhenDate2Bigger() {
        // given
        Instant time1 = LocalDateTime.of(2023, 5, 7, 9, 30).toInstant(UTC);
        Instant time2 = LocalDateTime.of(2023, 5, 7, 9, 35).toInstant(UTC);
        long expectedDifferenceSeconds = 5 * 60;

        // when
        long result = calculator(time1, time2).secondsBetween();

        // then
        assertEquals(expectedDifferenceSeconds, result);
    }

    @Test
    void shouldReturnNegativeValueWhenDate1Bigger() {
        // given
        Instant time1 = LocalDateTime.of(2023, 5, 7, 9, 30).toInstant(UTC);
        Instant time2 = LocalDateTime.of(2023, 5, 7, 9, 25).toInstant(UTC);
        long expectedDifferenceSeconds = -5 * 60;

        // when
        long result = calculator(time1, time2).secondsBetween();

        // then
        assertEquals(expectedDifferenceSeconds, result);
    }
}
