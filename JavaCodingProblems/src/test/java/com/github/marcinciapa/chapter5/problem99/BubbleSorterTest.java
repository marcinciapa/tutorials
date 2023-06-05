package com.github.marcinciapa.chapter5.problem99;

class BubbleSorterTest extends ArraySorterTest<BubbleSorter> {

    @Override
    ArraySorter sorter() {
        return new BubbleSorter();
    }
}
