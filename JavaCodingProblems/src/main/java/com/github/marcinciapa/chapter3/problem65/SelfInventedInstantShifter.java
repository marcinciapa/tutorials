package com.github.marcinciapa.chapter3.problem65;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;

class SelfInventedInstantShifter implements InstantShifter {

    private final Instant initialInstant;

    SelfInventedInstantShifter(Instant initialInstant) {
        this.initialInstant = initialInstant;
    }

    @Override
    public Instant addDays(int days) {
        return initialInstant.plus(days, DAYS);
    }

    @Override
    public Instant minusHours(int hours) {
        return initialInstant.minus(hours, HOURS);
    }
}
