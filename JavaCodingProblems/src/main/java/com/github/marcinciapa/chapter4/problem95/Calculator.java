package com.github.marcinciapa.chapter4.problem95;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;

class Calculator {

    private final List<Integer> numbers;

    Calculator(Collection<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    int sum() {
        // var calculation = Integer::sum; // Does not compile
        BinaryOperator<Integer> calculation = Integer::sum;
        return executeCalculation(calculation);
    }

    int multiply() {
        BinaryOperator<Integer> calculation = (var a, var b) -> a * b;
        return executeCalculation(calculation);
    }

    private int executeCalculation(BinaryOperator<Integer> calculation) {
        return numbers.stream()
                .reduce(calculation)
                .orElse(0);
    }
}
