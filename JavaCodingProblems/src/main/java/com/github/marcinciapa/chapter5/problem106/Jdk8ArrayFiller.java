package com.github.marcinciapa.chapter5.problem106;

import java.util.Arrays;

import static java.util.Objects.isNull;

class Jdk8ArrayFiller implements ArrayFiller {

    @Override
    public void fillWithFibonacci(int[] array) {
        if (isNull(array)) {
            throw new IllegalArgumentException();
        }

        Arrays.setAll(array, t -> {
            if (t == 0 || t == 1) {
                return 1;
            }
            return array[t - 2] + array[t - 1];
        });
    }
}
