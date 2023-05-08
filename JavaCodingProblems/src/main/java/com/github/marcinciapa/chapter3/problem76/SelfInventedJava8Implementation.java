package com.github.marcinciapa.chapter3.problem76;

import java.time.Duration;
import java.time.Instant;

class SelfInventedJava8Implementation implements TimeDifferenceCalculator {

    private final Instant instant1;
    private final Instant instant2;

    SelfInventedJava8Implementation(Instant instant1, Instant instant2) {
        this.instant1 = instant1;
        this.instant2 = instant2;
    }

    @Override
    public long secondsBetween() {
        return Duration.between(instant1, instant2).getSeconds();
    }
}
