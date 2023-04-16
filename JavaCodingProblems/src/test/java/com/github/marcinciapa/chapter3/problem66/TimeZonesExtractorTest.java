package com.github.marcinciapa.chapter3.problem66;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

abstract class TimeZonesExtractorTest<T extends TimeZonesExtractor> {

    abstract T extractor();

    @Test
    void shouldExtractTimeZones() {
        // given
        List<String> extractedZones = extractor().extractTimeZones();

        // then
        assertFalse(extractedZones.isEmpty());
        assertTrue(extractedZones.contains("CET"));
    }

}
