package com.github.marcinciapa.chapter3.problem73;

class Java9DateRangeIteratorTest extends DateRangeIteratorTest<Java9DateRangeIterator> {

    @Override
    Java9DateRangeIterator iterator(DayOfYear rangeStart, DayOfYear rangeEnd) {
        return new Java9DateRangeIterator(rangeStart, rangeEnd);
    }
}
