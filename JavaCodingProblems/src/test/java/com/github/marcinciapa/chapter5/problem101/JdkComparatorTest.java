package com.github.marcinciapa.chapter5.problem101;

class JdkComparatorTest extends ArrayComparatorTest<JdkComparator> {

    @Override
    JdkComparator comparator() {
        return new JdkComparator();
    }
}
