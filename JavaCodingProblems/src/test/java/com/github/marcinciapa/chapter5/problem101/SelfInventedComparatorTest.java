package com.github.marcinciapa.chapter5.problem101;

class SelfInventedComparatorTest extends ArrayComparatorTest<SelfInventedComparator> {

    @Override
    SelfInventedComparator comparator() {
        return new SelfInventedComparator();
    }
}
