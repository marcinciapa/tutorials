package com.github.marcinciapa.chapter1.problem25;

class SelfInventedMinMaxCalculator implements MinMaxCalculator {

    @Override
    public int max(int number1, int number2) {
        return Math.max(number1, number2);
    }

    @Override
    public int min(int number1, int number2) {
        return Math.min(number1, number2);
    }
}
