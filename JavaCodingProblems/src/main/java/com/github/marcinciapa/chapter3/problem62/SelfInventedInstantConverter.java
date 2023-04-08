package com.github.marcinciapa.chapter3.problem62;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class SelfInventedInstantConverter implements InstantConverter {

    @Override
    public ZonedDateTime toCet(Instant instant) {
        if (instant == null) {
            throw new IllegalArgumentException();
        }
        return instant.atZone(ZoneId.of("CET"));
    }

    @Override
    public Instant fromCet(ZonedDateTime cet) {
        if (cet == null) {
            throw new IllegalArgumentException();
        }
        return Instant.from(cet);
    }
}
