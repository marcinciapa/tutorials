package com.github.marcinciapa.chapter5.problem99;

class HeapSorterTest extends ArraySorterTest<HeapSorter> {
    @Override
    HeapSorter sorter() {
        return new HeapSorter();
    }
}
