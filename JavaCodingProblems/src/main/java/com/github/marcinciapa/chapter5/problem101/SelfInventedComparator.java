package com.github.marcinciapa.chapter5.problem101;

import static java.util.Objects.isNull;

class SelfInventedComparator implements ArrayComparator {

    @Override
    public boolean areEqual(int[] array1, int[] array2) {
        if(isNull(array1) || isNull(array2)) {
            throw new IllegalArgumentException();
        }

        if(array1.length != array2.length) {
            return false;
        }

        for(int i=0; i<array1.length; ++i) {
            if(array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }
}
