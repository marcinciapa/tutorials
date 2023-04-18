package com.github.marcinciapa.chapter3.problem67;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class CurrentTimeExtractorTest<T extends CurrentTimeExtractor> {

    abstract T extractor(Clock clock);

    @Test
    void shouldCurrentTime() {
        // given
        ZonedDateTime fixedTime = ZonedDateTime.of(2023, 12, 18, 20, 29, 43, 0, ZoneId.of("CET"));
        String expectedResult = "2023-12-18T20:29:43 CET";
        Instant fixedTimestamp = Instant.from(fixedTime);
        T extractor = extractor(Clock.fixed(fixedTimestamp, ZoneId.of("CET")));

        // when
        List<String> result = extractor.currentTime();

        // then
        assertTrue(result.size() > 1);
        assertTrue(result.contains(expectedResult));
    }
}
