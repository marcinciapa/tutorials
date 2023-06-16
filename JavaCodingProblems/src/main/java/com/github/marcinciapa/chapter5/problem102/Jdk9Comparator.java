package com.github.marcinciapa.chapter5.problem102;

import java.util.Arrays;

import static java.util.Objects.isNull;

class Jdk9Comparator implements ArrayComparator {

    @Override
    public int compare(int[] array1, int[] array2) {
        if (isNull(array1) || isNull(array2)) {
            throw new IllegalArgumentException();
        }
        return Arrays.compare(array1, array2);
    }
}
