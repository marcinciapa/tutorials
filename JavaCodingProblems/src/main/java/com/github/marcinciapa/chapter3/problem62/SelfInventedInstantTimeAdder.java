package com.github.marcinciapa.chapter3.problem62;

import java.time.Duration;
import java.time.Instant;

class SelfInventedInstantTimeAdder implements InstantTimeAdder {

    private final Instant initialInstant;

    SelfInventedInstantTimeAdder(Instant initialInstant) {
        this.initialInstant = initialInstant;
    }

    @Override
    public Instant add(Duration duration) {
        if(duration == null) {
            throw new IllegalArgumentException();
        }
        return initialInstant.plus(duration);
    }
}
