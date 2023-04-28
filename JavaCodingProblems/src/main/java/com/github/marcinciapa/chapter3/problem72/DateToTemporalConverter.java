package com.github.marcinciapa.chapter3.problem72;

import java.time.*;

interface DateToTemporalConverter {
    Instant toInstant();
    LocalDateTime toLocalDateTime();
    ZonedDateTime toZonedDateTime(ZoneId timeZone);
    LocalDate toLocalDate();
}
