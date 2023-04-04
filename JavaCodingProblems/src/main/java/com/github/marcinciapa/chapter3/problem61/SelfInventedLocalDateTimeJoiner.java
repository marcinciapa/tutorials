package com.github.marcinciapa.chapter3.problem61;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class SelfInventedLocalDateTimeJoiner implements LocalDateTimeJoiner {

    @Override
    public LocalDateTime toLocalDateTime(LocalDate date, LocalTime time) {
        if (date == null || time == null) {
            throw new IllegalArgumentException();
        }
        return LocalDateTime.of(date, time);
    }
}
