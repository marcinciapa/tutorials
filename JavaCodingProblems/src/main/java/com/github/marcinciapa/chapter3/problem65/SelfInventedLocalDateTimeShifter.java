package com.github.marcinciapa.chapter3.problem65;

import java.time.LocalDateTime;

class SelfInventedLocalDateTimeShifter implements LocalDateTimeShifter {

    private final LocalDateTime initialDate;

    SelfInventedLocalDateTimeShifter(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }

    @Override
    public LocalDateTime addDays(int days) {
        return initialDate.plusDays(days);
    }

    @Override
    public LocalDateTime subtractHours(int hours) {
        return initialDate.minusHours(hours);
    }
}
