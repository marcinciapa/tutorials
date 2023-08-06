package com.github.marcinciapa.chapter5.problem115;

class StreamKeySorterTest extends MapKeySorterTest<StreamSorter> {

    @Override
    StreamSorter sorter() {
        return new StreamSorter();
    }
}
