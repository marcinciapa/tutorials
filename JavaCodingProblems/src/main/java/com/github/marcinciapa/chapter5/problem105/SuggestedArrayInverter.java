package com.github.marcinciapa.chapter5.problem105;

import java.util.stream.IntStream;

import static java.util.Objects.isNull;

class SuggestedArrayInverter implements ArrayInverter {

    @Override
    public int[] invert(int[] array) {
        if (isNull(array)) {
            throw new IllegalArgumentException();
        }
        return IntStream.rangeClosed(1, array.length)
                .map(i -> array[array.length - i])
                .toArray();
    }
}
