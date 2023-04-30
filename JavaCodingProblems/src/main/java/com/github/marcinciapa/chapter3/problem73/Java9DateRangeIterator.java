package com.github.marcinciapa.chapter3.problem73;

import java.time.LocalDate;
import java.util.Iterator;

class Java9DateRangeIterator extends AbstractDateRangeIterator implements DateRangeIterator {

    Java9DateRangeIterator(DayOfYear rangeStart, DayOfYear rangeEnd) {
        super(rangeStart, rangeEnd);
    }

    @Override
    public Iterator<DayOfYear> iterate() {
        LocalDate startDate = LocalDate.of(rangeStart.year(), rangeStart.month(), rangeStart.day());
        LocalDate endDate = LocalDate.of(rangeEnd.year(), rangeEnd.month(), rangeEnd.day());

        return startDate.datesUntil(endDate)
                .map(this::toDayOfYear)
                .iterator();
    }

    private DayOfYear toDayOfYear(LocalDate date) {
        return new DayOfYear(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }
}
