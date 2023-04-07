package com.github.marcinciapa.chapter3.problem62;

import java.time.Clock;
import java.time.Instant;

class SelfInventedInstantProvider implements InstantProvider {

    private final Clock clock;

    SelfInventedInstantProvider(Clock clock) {
        this.clock = clock;
    }

    @Override
    public Instant currentInstant() {
        return Instant.now(clock);
    }
}
