package com.github.marcinciapa.chapter5.problem101;

import java.util.Optional;

import static java.util.Objects.isNull;

class SelfInventedMismatchFinder implements ArrayMismatchFinder {

    @Override
    public Optional<Integer> mismatch(int[] array1, int[] array2) {
        if (isNull(array1) || isNull(array2)) {
            throw new IllegalArgumentException();
        }

        int length = Math.max(array1.length, array2.length);

        for (int i = 0; i < length; ++i) {
            if (isMismatchAtIndex(i, array1, array2)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    private boolean isMismatchAtIndex(int i, int[] array1, int[] array2) {
        if (i >= array1.length) {
            return true;
        }
        if (i >= array2.length) {
            return true;
        }
        return array1[i] != array2[i];
    }
}
