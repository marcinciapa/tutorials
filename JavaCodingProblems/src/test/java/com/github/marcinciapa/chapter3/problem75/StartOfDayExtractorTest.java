package com.github.marcinciapa.chapter3.problem75;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class StartOfDayExtractorTest<T extends StartOfDateExtractor> {

    abstract T extractor();

    @ParameterizedTest
    @MethodSource("incorrectArguments")
    void shouldFailWhenNullPassed(LocalDate date, ZoneId zone) {
        assertThrows(IllegalArgumentException.class, () -> extractor().toStartOfDayUTC(date, zone));
    }

    @ParameterizedTest
    @MethodSource("testInput")
    void shouldGetStartOfDayInUtc(LocalDate date, ZoneId zone, LocalDateTime expectedResult) {
        // when
        LocalDateTime result = extractor().toStartOfDayUTC(date, zone);

        // then
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(LocalDate.of(2023, 5, 6), UTC, LocalDateTime.of(2023, 5, 6, 0, 0)),
                Arguments.of(LocalDate.of(2023, 5, 6), ZoneId.of("Europe/Warsaw"), LocalDateTime.of(2023, 5, 5, 22, 0)),
                Arguments.of(LocalDate.of(2023, 12, 3), ZoneId.of("Europe/Warsaw"), LocalDateTime.of(2023, 12, 2, 23, 0)),
                Arguments.of(LocalDate.of(2023, 5, 6), ZoneId.of("America/Los_Angeles"), LocalDateTime.of(2023, 5, 6, 7, 0))
        );
    }

    static Stream<Arguments> incorrectArguments() {
        return Stream.of(
                Arguments.of(LocalDate.now(), null),
                Arguments.of(null, UTC),
                Arguments.of(null, null)
        );
    }
}
