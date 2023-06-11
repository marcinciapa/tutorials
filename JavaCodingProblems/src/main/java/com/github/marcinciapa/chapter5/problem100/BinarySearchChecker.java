package com.github.marcinciapa.chapter5.problem100;

import java.util.Arrays;
import java.util.Comparator;

class BinarySearchChecker implements ElementChecker {

    @Override
    public <T> boolean contains(T element, T[] array, Comparator<T> comparator) {
        if (array == null || comparator == null) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(array, comparator);
        int index = Arrays.binarySearch(array, element, comparator);
        return index >= 0;
    }
}
