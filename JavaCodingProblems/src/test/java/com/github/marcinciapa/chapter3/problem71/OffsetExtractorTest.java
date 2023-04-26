package com.github.marcinciapa.chapter3.problem71;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class OffsetExtractorTest<T extends OffsetExtractor> {

    abstract T offsetExtractor();

    @Test
    void shouldFailWhenArgumentNull() {
        assertThrows(IllegalArgumentException.class, () -> offsetExtractor().getOffset(null));
    }

    @Test
    void shouldFailWhenArgumentIncorrect() {
        assertThrows(IllegalArgumentException.class, () -> offsetExtractor().getOffset("IncorrectTimezone"));
    }

    @Test
    void shouldExtractOffsetFromTimeZone() {
        // given
        String timeZone = "Europe/Warsaw";
        int expectedResult = 60 * /*minutes*/ 60 * /*seconds*/ 1000/*milliseconds*/;

        // when
        int result = offsetExtractor().getOffset(timeZone);

        // then
        assertEquals(expectedResult, result);
    }
}
