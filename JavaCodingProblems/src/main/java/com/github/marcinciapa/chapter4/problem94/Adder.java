package com.github.marcinciapa.chapter4.problem94;

import java.util.Collection;

class Adder {

    private final Collection<Integer> numbers;

    Adder(NumbersProvider numbersProvider) {
        this.numbers = numbersProvider.provide();
    }

    int sum() {
        return this.numbers
                .stream()
                .reduce(0, Integer::sum);
    }
}
