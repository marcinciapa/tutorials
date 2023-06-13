package com.github.marcinciapa.chapter5.problem100;

import java.util.Optional;

import static java.util.Objects.isNull;

class SelfInventedFinder implements ElementFinder {

    @Override
    public Optional<Integer> firstIndexOf(int element, int[] array) {
        if (isNull(array)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == element) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}
