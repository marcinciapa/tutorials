package com.github.marcinciapa.chapter3.problem73;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import static java.util.Calendar.*;

class Java7DateRangeIterator implements DateRangeIterator {

    private final DayOfYear rangeStart;
    private final DayOfYear rangeEnd;

    public Java7DateRangeIterator(DayOfYear rangeStart, DayOfYear rangeEnd) {
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

    @Override
    public Iterator<DayOfYear> iterate() {
        LinkedList<DayOfYear> daysInRange = new LinkedList<>();

        Calendar calendar = Calendar.getInstance();

        calendar.set(rangeStart.year(), rangeStart.month() - 1, rangeStart.day());
        Date startDate = calendar.getTime();

        calendar.set(rangeEnd.year(), rangeEnd.month() - 1, rangeEnd.day());
        Date endDate = calendar.getTime();

        Date nextDay = startDate;
        while (nextDay.before(endDate)) {
            calendar.setTime(nextDay);
            daysInRange.add(new DayOfYear(calendar.get(YEAR), calendar.get(MONTH) + 1, calendar.get(DAY_OF_MONTH)));
            calendar.add(DAY_OF_MONTH, 1);
            nextDay = calendar.getTime();
        }


        return daysInRange.iterator();
    }
}
