package com.github.marcinciapa.chapter1.problem38;

class SelfInventedFMA implements FMA {

    @Override
    public float calculate(float a, float b, float c) {
        return a*b+c;
    }
}
