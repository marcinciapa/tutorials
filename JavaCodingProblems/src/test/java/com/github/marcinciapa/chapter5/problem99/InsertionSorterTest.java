package com.github.marcinciapa.chapter5.problem99;

class InsertionSorterTest extends ArraySorterTest<InsertionSorter> {

    @Override
    InsertionSorter sorter() {
        return new InsertionSorter();
    }
}
