package com.github.marcinciapa.chapter5.problem115;

class StreamValueSorterTest extends MapValueSorterTest<StreamSorter> {

    @Override
    StreamSorter sorter() {
        return new StreamSorter();
    }
}
