package com.github.marcinciapa.chapter5.problem101;

import java.util.Arrays;
import java.util.Optional;

import static java.util.Objects.isNull;

class Jdk9MismatchFinder implements ArrayMismatchFinder {

    @Override
    public Optional<Integer> mismatch(int[] array1, int[] array2) {
        if (isNull(array1) || isNull(array2)) {
            throw new IllegalArgumentException();
        }
        int mismatch = Arrays.mismatch(array1, array2);

        return mismatch >= 0
                ? Optional.of(mismatch)
                : Optional.empty();
    }
}
