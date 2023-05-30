package com.github.marcinciapa.chapter4.problem98;

import java.util.List;

class Calculator {

    private final List<?> numbers;

    Calculator(List<?> numbers) {
        this.numbers = numbers;
    }


    public int add() {
        var sum = 0;
        for(Object o: numbers) {
            if(o instanceof Integer i) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
