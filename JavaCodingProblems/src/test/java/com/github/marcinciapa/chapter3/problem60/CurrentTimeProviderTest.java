package com.github.marcinciapa.chapter3.problem60;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZonedDateTime;

import static java.time.ZoneOffset.UTC;

abstract class CurrentTimeProviderTest<T extends CurrentTimeProvider> {

    abstract T createInstance(Clock clock);

    @Test
    void shouldProvideCurrentTime() {
        // given
        ZonedDateTime expectedCurrentTime = ZonedDateTime.of(2023, 4, 3, 11, 2, 14, 0, UTC);
        Clock clock = Clock.fixed(Instant.parse("2023-04-03T11:02:14Z"), UTC);
        T currentTimeProvider = createInstance(clock);

        // when
        ZonedDateTime providedCurrentTime = currentTimeProvider.currentTime();

        // then
        Assertions.assertEquals(expectedCurrentTime, providedCurrentTime);
    }
}
