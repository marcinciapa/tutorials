package com.github.marcinciapa.chapter5.problem99;

class JdkSorterTest extends ArraySorterTest<JdkSorter> {

    @Override
    ArraySorter sorter() {
        return new JdkSorter();
    }
}
