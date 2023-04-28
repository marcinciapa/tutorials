package com.github.marcinciapa.chapter3.problem72;

import java.time.*;
import java.util.Date;

import static java.time.ZoneOffset.UTC;

class SelfInventedDateToTemporalConverter implements DateToTemporalConverter {

    private final Date date;

    public SelfInventedDateToTemporalConverter(Date date) {
        if (date == null) {
            throw new IllegalArgumentException();
        }
        this.date = date;
    }

    @Override
    public Instant toInstant() {
        return date.toInstant();
    }

    @Override
    public LocalDateTime toLocalDateTime() {
        return LocalDateTime.ofInstant(toInstant(), UTC);
    }

    @Override
    public ZonedDateTime toZonedDateTime(ZoneId timeZone) {
        return ZonedDateTime.ofInstant(toInstant(), timeZone);
    }

    @Override
    public LocalDate toLocalDate() {
        return LocalDate.ofInstant(toInstant(), UTC);
    }
}
