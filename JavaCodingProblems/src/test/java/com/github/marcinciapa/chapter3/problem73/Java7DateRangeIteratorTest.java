package com.github.marcinciapa.chapter3.problem73;

class Java7DateRangeIteratorTest extends DateRangeIteratorTest<Java7DateRangeIterator> {

    @Override
    Java7DateRangeIterator iterator(DayOfYear rangeStart, DayOfYear rangeEnd) {
        return new Java7DateRangeIterator(rangeStart, rangeEnd);
    }
}
