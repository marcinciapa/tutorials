package com.github.marcinciapa.chapter3.problem73;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

class Java8DateRangeIterator extends AbstractDateRangeIterator implements DateRangeIterator {

    Java8DateRangeIterator(DayOfYear rangeStart, DayOfYear rangeEnd) {
        super(rangeStart, rangeEnd);
    }

    @Override
    public Iterator<DayOfYear> iterate() {
        LocalDate startDay = LocalDate.of(rangeStart.year(), rangeStart.month(), rangeStart.day());
        LocalDate endDay = LocalDate.of(rangeEnd.year(), rangeEnd.month(), rangeEnd.day());

        LinkedList<DayOfYear> result = new LinkedList<>();

        LocalDate current = LocalDate.from(startDay);
        while (current.isBefore(endDay)) {
            result.add(new DayOfYear(current.getYear(), current.getMonthValue(), current.getDayOfMonth()));
            current = current.plusDays(1);
        }

        return result.iterator();
    }
}
