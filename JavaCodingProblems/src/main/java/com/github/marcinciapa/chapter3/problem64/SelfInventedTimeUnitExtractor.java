package com.github.marcinciapa.chapter3.problem64;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

class SelfInventedTimeUnitExtractor implements TimeUnitExtractor {

    @Override
    public int get(ChronoField unit, LocalDateTime dateTime) {
        if (dateTime == null || unit == null) {
            throw new IllegalArgumentException();
        }
        return dateTime.get(unit);
    }
}
