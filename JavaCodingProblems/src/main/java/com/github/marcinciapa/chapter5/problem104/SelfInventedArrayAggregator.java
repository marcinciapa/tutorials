package com.github.marcinciapa.chapter5.problem104;

import java.util.Arrays;

import static java.util.Objects.isNull;

class SelfInventedArrayAggregator implements ArrayAggregator {

    private final int[] array;

    SelfInventedArrayAggregator(int[] array) {
        if (isNull(array) || array.length == 0) {
            throw new IllegalArgumentException();
        }

        this.array = array;
    }

    @Override
    public int min() {
        //noinspection OptionalGetWithoutIsPresent
        return Arrays.stream(array)
                .min()
                .getAsInt();
    }

    @Override
    public int max() {
        //noinspection OptionalGetWithoutIsPresent
        return Arrays.stream(array)
                .max()
                .getAsInt();
    }
}
