package com.github.marcinciapa.chapter5.problem100;

import java.util.Comparator;

class SelfInventedChecker implements ElementChecker {

    @Override
    public <T> boolean contains(T element, T[] array, Comparator<T> comparator) {
        if (array == null || comparator == null) {
            throw new IllegalArgumentException();
        }

        for (T t : array) {
            if (comparator.compare(element, t) == 0) {
                return true;
            }
        }

        return false;
    }
}
