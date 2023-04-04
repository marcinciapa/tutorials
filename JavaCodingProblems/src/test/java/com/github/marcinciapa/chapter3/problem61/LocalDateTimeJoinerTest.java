package com.github.marcinciapa.chapter3.problem61;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class LocalDateTimeJoinerTest<T extends LocalDateTimeJoiner> {

    abstract T createInstance();

    @ParameterizedTest
    @MethodSource("invalidArgumentDataProvider")
    void shouldFailIfArgumentInvalid(LocalDate date, LocalTime time) {
        T joiner = createInstance();

        assertThrows(IllegalArgumentException.class, () -> joiner.toLocalDateTime(date, time));
    }

    @Test
    void shouldJoinDateAndTime() {
        // given
        T joiner = createInstance();
        LocalDate date = LocalDate.of(2023, 4, 4);
        LocalTime time = LocalTime.of(16, 49, 20);
        LocalDateTime expected = LocalDateTime.of(2023, 4, 4, 16, 49, 20);

        // when
        LocalDateTime result = joiner.toLocalDateTime(date, time);

        // then
        assertEquals(expected, result);
    }

    static Stream<Arguments> invalidArgumentDataProvider() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(LocalDate.now(), null),
                Arguments.of(null, LocalTime.now())
        );
    }
}
