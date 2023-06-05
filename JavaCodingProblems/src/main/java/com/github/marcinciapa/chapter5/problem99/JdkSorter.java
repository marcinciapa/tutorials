package com.github.marcinciapa.chapter5.problem99;

import java.util.Arrays;

class JdkSorter implements ArraySorter {

    @Override
    public Integer[] sort(Integer[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(array);
        return array;
    }
}
