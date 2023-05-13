package com.github.marcinciapa.chapter4.problem80;

class IntCalculator implements Calculator<Integer> {

    private final int number1;
    private final int number2;

    IntCalculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public Integer multiply() {
        return number1 * number2;
    }
}
