package com.github.marcinciapa.chapter3.problem73;

class Java8DateRangeIteratorTest extends DateRangeIteratorTest<Java8DateRangeIterator> {

    @Override
    Java8DateRangeIterator iterator(DayOfYear rangeStart, DayOfYear rangeEnd) {
        return new Java8DateRangeIterator(rangeStart, rangeEnd);
    }
}
