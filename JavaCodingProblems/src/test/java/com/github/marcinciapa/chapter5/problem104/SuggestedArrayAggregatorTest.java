package com.github.marcinciapa.chapter5.problem104;

class SuggestedArrayAggregatorTest extends ArrayAggregatorTest<SuggestedArrayAggregator> {

    @Override
    SuggestedArrayAggregator aggregator(int[] array) {
        return new SuggestedArrayAggregator(array);
    }
}
