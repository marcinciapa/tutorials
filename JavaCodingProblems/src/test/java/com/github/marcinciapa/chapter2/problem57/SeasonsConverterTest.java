package com.github.marcinciapa.chapter2.problem57;

import org.junit.jupiter.api.Test;

import static com.github.marcinciapa.chapter2.problem57.Season.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SeasonsConverterTest {

    @Test
    void shouldConvertSeason() {
        SeasonsConverter converter = new SeasonsConverter();
        assertEquals("Spring", converter.convert(SPRING));
        assertEquals("Summer", converter.convert(SUMMER));
        assertEquals("Fall", converter.convert(FALL));
        assertEquals("Winter", converter.convert(WINTER));
    }

    @Test
    void shouldThrowWhenIncorrectSeasonPassed() {
        SeasonsConverter converter = new SeasonsConverter();
        assertThrows(IllegalArgumentException.class, () -> converter.convert(null));
    }
}
