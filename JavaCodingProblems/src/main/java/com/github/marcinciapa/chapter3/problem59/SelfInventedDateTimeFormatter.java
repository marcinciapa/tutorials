package com.github.marcinciapa.chapter3.problem59;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class SelfInventedDateTimeFormatter implements DateTimeFormatter {

    public static final java.time.format.DateTimeFormatter FORMAT =
            java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Override
    public String format(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException();
        }

        LocalDateTime dateTimeMinutes = dateTime.truncatedTo(ChronoUnit.MINUTES);

        return dateTimeMinutes.format(FORMAT);
    }
}
