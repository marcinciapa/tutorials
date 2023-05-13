package com.github.marcinciapa.chapter4.problem80;

class LongCalculator implements Calculator<Long> {

    private final int number1;
    private final int number2;

    LongCalculator(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public Long multiply() {
        return (long) number1 * (long) number2;
    }
}
