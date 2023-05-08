package com.github.marcinciapa.chapter3.problem76;

import java.time.Instant;
import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static java.time.temporal.ChronoUnit.SECONDS;

class SuggestedJava8Implementation implements TimeDifferenceCalculator {

    private final LocalDateTime time1;
    private final LocalDateTime time2;

    public SuggestedJava8Implementation(Instant time1, Instant time2) {
        this.time1 = LocalDateTime.ofInstant(time1, UTC);
        this.time2 = LocalDateTime.ofInstant(time2, UTC);
    }

    @Override
    public long secondsBetween() {
        return SECONDS.between(time1, time2);
    }
}
