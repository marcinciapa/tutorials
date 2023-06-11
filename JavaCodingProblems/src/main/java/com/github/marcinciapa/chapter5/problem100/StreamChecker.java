package com.github.marcinciapa.chapter5.problem100;

import java.util.Arrays;
import java.util.Comparator;

class StreamChecker implements ElementChecker {

    @Override
    public <T> boolean contains(T element, T[] array, Comparator<T> comparator) {
        if(array == null || comparator == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(array)
                .anyMatch(e -> comparator.compare(e, element) == 0);
    }
}
