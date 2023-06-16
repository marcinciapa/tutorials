package com.github.marcinciapa.chapter5.problem102;

class Jdk9ComparatorTest extends ArrayComparatorTest<Jdk9Comparator> {

    @Override
    Jdk9Comparator comparator() {
        return new Jdk9Comparator();
    }
}
