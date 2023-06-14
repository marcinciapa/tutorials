package com.github.marcinciapa.chapter5.problem101;

import java.util.Arrays;

import static java.util.Objects.isNull;

class JdkComparator implements ArrayComparator {

    @Override
    public boolean areEqual(int[] array1, int[] array2) {
        if (isNull(array1) || isNull(array2)) {
            throw new IllegalArgumentException();
        }

        return Arrays.equals(array1, array2);
    }
}
