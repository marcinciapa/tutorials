package com.github.marcinciapa.chapter3.problem63;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

class SelfInventedInstantShifter implements InstantShifter {

    @Override
    public Instant after(Instant instant, Period period) {
        if (instant == null || period == null) {
            throw new IllegalArgumentException();
        }
        return instant.plus(period);
    }

    @Override
    public Instant after(Instant instant, Duration duration) {
        if (instant == null || duration == null) {
            throw new IllegalArgumentException();
        }
        return instant.plus(duration);
    }
}
