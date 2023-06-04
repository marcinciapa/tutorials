package com.github.marcinciapa.chapter5.problem99;

class SelfInventedJdkSorterTest extends ArraySorterTest<SelfInventedJdkSorter> {

    @Override
    ArraySorter sorter() {
        return new SelfInventedJdkSorter();
    }
}
