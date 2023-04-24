package com.github.marcinciapa.chapter3.problem70;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.temporal.ChronoField.*;

class SelfInventedFirstLastDayOfMonthFinder implements FirstLastDayOfMonthFinder {

    private final LocalDateTime initialDate;

    SelfInventedFirstLastDayOfMonthFinder(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }

    @Override
    public LocalDate firstDayOfMonth() {
        TemporalAdjuster adjuster = TemporalAdjusters.firstDayOfMonth();
        return adjustInitialDate(adjuster);
    }

    @Override
    public LocalDate lastDayOfMonth() {
        TemporalAdjuster adjuster = TemporalAdjusters.lastDayOfMonth();
        return adjustInitialDate(adjuster);
    }

    private LocalDate adjustInitialDate(TemporalAdjuster adjuster) {
        Temporal adjusted = adjuster.adjustInto(initialDate);
        return LocalDate.of(
                adjusted.get(YEAR),
                adjusted.get(MONTH_OF_YEAR),
                adjusted.get(DAY_OF_MONTH)
        );
    }
}
