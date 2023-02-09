package com.github.marcinciapa.chapter1.problem37;

class SelfInventedMultiplier implements Multiplier {

    @Override
    public int multiply(int number1, int number2) {
        return Math.multiplyExact(number1, number2);
    }
}
