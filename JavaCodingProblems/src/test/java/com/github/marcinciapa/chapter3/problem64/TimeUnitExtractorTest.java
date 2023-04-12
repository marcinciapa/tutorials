package com.github.marcinciapa.chapter3.problem64;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.stream.Stream;

import static java.time.temporal.ChronoField.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class TimeUnitExtractorTest<T extends TimeUnitExtractor> {

    abstract T extractor();

    @ParameterizedTest
    @MethodSource("incorrectArguments")
    void shouldFailWhenArgumentIncorrect(LocalDateTime dateTime, ChronoField unit) {
        assertThrows(IllegalArgumentException.class, () -> extractor().get(unit, dateTime));
    }

    static Stream<Arguments> incorrectArguments() {
        return Stream.of(
                Arguments.of(LocalDateTime.now(), null),
                Arguments.of(null, YEAR),
                Arguments.of(null, null)
        );
    }

    @Test
    void shouldExtractYear() {
        // given
        LocalDateTime dateTime = LocalDateTime.of(2023, 4, 12, 13, 5);
        T extractor = extractor();

        // when
        int year = extractor.get(YEAR, dateTime);
        int month = extractor.get(MONTH_OF_YEAR, dateTime);
        int day = extractor.get(DAY_OF_MONTH, dateTime);
        int hour = extractor.get(HOUR_OF_DAY, dateTime);
        int minute = extractor.get(MINUTE_OF_HOUR, dateTime);

        // then
        assertEquals(2023, year);
        assertEquals(4, month);
        assertEquals(12, day);
        assertEquals(13, hour);
        assertEquals(5, minute);
    }
}
