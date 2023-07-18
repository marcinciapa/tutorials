package com.github.marcinciapa.chapter5.problem111;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Map;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeTest {

    private Map<String, Instant> stringWithAccessTime = Map.of(
            "this", Instant.ofEpochMilli(1000),
            "is", Instant.ofEpochMilli(2000),
            "test", Instant.ofEpochMilli(4000)
    );

    private static final Clock clock = Clock.fixed(Instant.ofEpochMilli(3000), UTC);

    @Test
    void shouldUpdateAccessTimeWhenLaterThenExisting() {
        // given
        Merge merge = new Merge(stringWithAccessTime, clock);
        String resource = "is";

        // when
        String accessed = merge.access(resource);

        // then
        assertEquals(resource, accessed);
        assertEquals(Instant.ofEpochMilli(3000), merge.lastAccessed(resource));
    }

    @Test
    void shouldNotUpdateAccessTimeWhenEarlierThanExisting() {
        // given
        Merge merge = new Merge(stringWithAccessTime, clock);
        String resource = "test";

        // when
        String accessed = merge.access(resource);

        // then
        assertEquals(resource, accessed);
        assertEquals(Instant.ofEpochMilli(4000), merge.lastAccessed(resource));
    }

    @Test
    void shouldSetNewAccessTimeWhenNotExists() {
        // given
        Merge merge = new Merge(stringWithAccessTime, clock);
        String resource = "a";

        // when
        String accessed = merge.access(resource);

        // then
        assertEquals(resource, accessed);
        assertEquals(Instant.ofEpochMilli(3000), merge.lastAccessed(resource));
    }
}
