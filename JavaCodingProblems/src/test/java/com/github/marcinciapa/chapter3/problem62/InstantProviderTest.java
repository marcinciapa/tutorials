package com.github.marcinciapa.chapter3.problem62;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

abstract class InstantProviderTest<T extends InstantProvider> {

    abstract T provider(Clock clock);

    @Test
    void shouldProvideCurrentInstant() {
        // given
        Instant now = Instant.now();
        Clock clock = Clock.fixed(now, UTC);
        T provider = provider(clock);

        // when
        Instant instant1 = provider.currentInstant();

        // then
        assertEquals(now, instant1);
        assertFalse(instant1.isAfter(now));
        assertFalse(instant1.isBefore(now));
    }
}
