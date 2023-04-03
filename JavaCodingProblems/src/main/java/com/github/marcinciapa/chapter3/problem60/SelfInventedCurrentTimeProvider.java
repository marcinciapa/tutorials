package com.github.marcinciapa.chapter3.problem60;

import java.time.Clock;
import java.time.Instant;
import java.time.ZonedDateTime;

class SelfInventedCurrentTimeProvider implements CurrentTimeProvider {

    private final Clock clock;

    SelfInventedCurrentTimeProvider(Clock clock) {
        this.clock = clock;
    }

    @Override
    public ZonedDateTime currentTime() {
        return ZonedDateTime.now(clock);
    }
}
