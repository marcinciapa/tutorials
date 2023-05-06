package com.github.marcinciapa.chapter3.problem75;

import java.time.*;

import static java.time.ZoneOffset.UTC;

class SuggestedStartOfDayExtractor implements StartOfDateExtractor {

    @Override
    public LocalDateTime toStartOfDayUTC(LocalDate date, ZoneId zone) {
        if (date == null || zone == null) {
            throw new IllegalArgumentException();
        }

        ZonedDateTime localStartOfDay = date.atStartOfDay(zone);
        ZonedDateTime utcStartOfDay = localStartOfDay.withZoneSameInstant(UTC);
        return utcStartOfDay.toLocalDateTime();
    }
}
