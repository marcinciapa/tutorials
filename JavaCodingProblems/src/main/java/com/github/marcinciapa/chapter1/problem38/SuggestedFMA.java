package com.github.marcinciapa.chapter1.problem38;

class SuggestedFMA implements FMA {

    @Override
    public float calculate(float a, float b, float c) {
        return Math.fma(a, b, c);
    }
}
