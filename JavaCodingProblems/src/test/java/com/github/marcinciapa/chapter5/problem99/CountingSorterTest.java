package com.github.marcinciapa.chapter5.problem99;

class CountingSorterTest extends ArraySorterTest<CountingSorter> {

    @Override
    CountingSorter sorter() {
        return new CountingSorter();
    }
}
