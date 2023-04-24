package com.github.marcinciapa.chapter3.problem70;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

class SuggestedFirstLastDayOfMonthFinder implements FirstLastDayOfMonthFinder {

    private final LocalDateTime initialDate;

    SuggestedFirstLastDayOfMonthFinder(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }

    @Override
    public LocalDate firstDayOfMonth() {
        return initialDate.with(TemporalAdjusters.firstDayOfMonth()).toLocalDate();
    }

    @Override
    public LocalDate lastDayOfMonth() {
        return initialDate.with(TemporalAdjusters.lastDayOfMonth()).toLocalDate();
    }
}
