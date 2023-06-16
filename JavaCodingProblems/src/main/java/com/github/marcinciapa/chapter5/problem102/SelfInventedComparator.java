package com.github.marcinciapa.chapter5.problem102;

import static java.util.Objects.isNull;

class SelfInventedComparator implements ArrayComparator {

    @Override
    public int compare(int[] array1, int[] array2) {
        if (isNull(array1) || isNull(array2)) {
            throw new IllegalArgumentException();
        }

        int maxLength = Math.max(array1.length, array2.length);

        for (int i = 0; i < maxLength; ++i) {
            if (i >= array1.length) {
                return -(i+1);
            }
            if (i >= array2.length) {
                return i+1;
            }
            if (array1[i] != array2[i]) {
                return Integer.compare(array1[i], array2[i]);
            }
        }

        return 0;
    }
}
