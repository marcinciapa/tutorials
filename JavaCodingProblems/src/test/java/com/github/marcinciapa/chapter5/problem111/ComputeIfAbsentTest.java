package com.github.marcinciapa.chapter5.problem111;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Map;

import static java.time.ZoneId.systemDefault;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputeIfAbsentTest {

    private static final Map<String, Instant> MAP = Map.of(
            "one", Instant.ofEpochMilli(1000),
            "two", Instant.ofEpochMilli(2000),
            "three", Instant.ofEpochMilli(3000)
    );

    @Test
    void shouldReturnValueIfPresent() {
        // given
        ComputeIfAbsent computer = new ComputeIfAbsent(MAP, Clock.system(systemDefault()));

        // when
        Instant value = computer.get("two");

        // then
        assertEquals(Instant.ofEpochMilli(2000), value);
    }

    @Test
    void shouldComputeAndReturnIfAbsent() {
        // given
        Instant fixedInstant = Instant.ofEpochMilli(4000);
        ComputeIfAbsent computer = new ComputeIfAbsent(MAP, Clock.fixed(fixedInstant, systemDefault()));

        // when
        Instant value = computer.get("four");

        // then
        assertEquals(fixedInstant, value);
    }
}
