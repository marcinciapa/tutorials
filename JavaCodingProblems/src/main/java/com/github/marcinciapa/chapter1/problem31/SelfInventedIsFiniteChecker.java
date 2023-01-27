package com.github.marcinciapa.chapter1.problem31;

class SelfInventedIsFiniteChecker implements IsFiniteChecker {

    @Override
    public boolean isFinite(float number) {
        return Float.isFinite(number);
    }
}
