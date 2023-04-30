package com.github.marcinciapa.chapter3.problem73;

import java.time.LocalDate;

abstract class AbstractDateRangeIterator {

    protected final DayOfYear rangeStart;
    protected final DayOfYear rangeEnd;

    protected AbstractDateRangeIterator(DayOfYear rangeStart, DayOfYear rangeEnd) {
        if (rangeStart == null || rangeEnd == null) {
            throw new IllegalArgumentException();
        }
        LocalDate localRangeStart = LocalDate.of(rangeStart.year(), rangeStart.month(), rangeStart.day());
        LocalDate localRangeEnd = LocalDate.of(rangeEnd.year(), rangeEnd.month(), rangeEnd.day());
        if (localRangeEnd.isBefore(localRangeStart)) {
            throw new IllegalArgumentException();
        }
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }
}
