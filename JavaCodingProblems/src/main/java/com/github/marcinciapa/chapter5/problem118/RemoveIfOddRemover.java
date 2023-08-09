package com.github.marcinciapa.chapter5.problem118;

import java.util.List;

import static java.util.Objects.isNull;

class RemoveIfOddRemover implements OddRemover {

    @Override
    public void removeOdd(List<Integer> numbers) {
        if (isNull(numbers)) {
            throw new IllegalArgumentException();
        }
        numbers.removeIf(number -> number % 2 != 0);
    }
}
