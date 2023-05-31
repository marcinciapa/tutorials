package com.github.marcinciapa.chapter4.problem98;

import java.util.List;

class NumberCalculator {

    private final List<? extends Number> numbers;

    NumberCalculator(List<? extends Number> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        var sum = 0;
        for(var number : numbers) {
            if(number instanceof Integer intNumber) {
                sum += intNumber;
            }
        }
        return sum;
    }
}
