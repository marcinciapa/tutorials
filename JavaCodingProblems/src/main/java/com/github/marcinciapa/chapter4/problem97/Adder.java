package com.github.marcinciapa.chapter4.problem97;

import java.util.ArrayList;
import java.util.List;

class Adder<T extends Number> {

    private final List<T> numbers;

    Adder(List<T> numbers) {
        this.numbers = numbers;
    }

    T sum() {
        var numbersCopy = new ArrayList<>(numbers);
        Integer result = numbersCopy.stream()
                .map(T::intValue)
                .reduce(0, Integer::sum);
        return (T) result;
    }
}
