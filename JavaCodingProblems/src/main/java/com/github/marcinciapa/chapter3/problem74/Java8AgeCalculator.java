package com.github.marcinciapa.chapter3.problem74;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static java.time.ZoneOffset.UTC;
import static java.time.temporal.ChronoUnit.YEARS;

class Java8AgeCalculator implements AgeCalculator {

    private final LocalDateTime dateOfBirth;
    private final LocalDateTime now;

    Java8AgeCalculator(Instant dateOfBirth, Clock clock) {
        this.dateOfBirth = LocalDateTime.ofInstant(dateOfBirth, UTC);
        this.now = now(clock);
    }

    @Override
    public int calculateAge() {
        return (int) YEARS.between(dateOfBirth, now);
    }
}
