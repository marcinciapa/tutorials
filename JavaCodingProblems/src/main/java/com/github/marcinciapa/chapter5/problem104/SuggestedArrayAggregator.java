package com.github.marcinciapa.chapter5.problem104;

import static java.util.Objects.isNull;

class SuggestedArrayAggregator implements ArrayAggregator {

    private final int[] array;

    SuggestedArrayAggregator(int[] array) {
        if (isNull(array) || array.length == 0) {
            throw new IllegalArgumentException();
        }
        this.array = array;
    }

    @Override
    public int min() {
        int min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public int max() {
        int max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
