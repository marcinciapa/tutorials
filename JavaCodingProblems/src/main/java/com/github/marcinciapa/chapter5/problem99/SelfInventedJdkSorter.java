package com.github.marcinciapa.chapter5.problem99;

import java.util.Arrays;

class SelfInventedJdkSorter implements ArraySorter {

    @Override
    public Integer[] sort(Integer[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(array);
        return array;
    }
}
