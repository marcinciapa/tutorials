package com.github.marcinciapa.chapter4.problem93;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Objects.isNull;

class NumbersAdder {

    private final Collection<Integer> numbers;

    NumbersAdder(NumbersProvider numbersProvider) {
        if(isNull(numbersProvider)) {
            throw new IllegalArgumentException();
        }
        Collection<Integer> providedNumbers = numbersProvider.provideNumbers();
        if(isNull(providedNumbers)) {
            throw new IllegalArgumentException();
        }
        this.numbers = new ArrayList<>(providedNumbers);
    }

    int add() {
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
