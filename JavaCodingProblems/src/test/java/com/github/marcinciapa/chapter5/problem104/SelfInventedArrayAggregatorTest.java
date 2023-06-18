package com.github.marcinciapa.chapter5.problem104;

class SelfInventedArrayAggregatorTest extends ArrayAggregatorTest<SelfInventedArrayAggregator> {

    @Override
    SelfInventedArrayAggregator aggregator(int[] array) {
        return new SelfInventedArrayAggregator(array);
    }
}
