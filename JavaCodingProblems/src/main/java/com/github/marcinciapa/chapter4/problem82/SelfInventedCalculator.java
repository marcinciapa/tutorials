package com.github.marcinciapa.chapter4.problem82;

class SelfInventedCalculator implements Calculator {

    private final int number1;
    private final int number2;

    SelfInventedCalculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public int add() {
        return number1 + number2;
    }
}
