package com.github.marcinciapa.chapter1.problem36;

class SuggestedNextFloatGenerator implements NextFloatGenerator {

    @Override
    public float nextUp(float number) {
        if (number == Float.POSITIVE_INFINITY || number == Float.NEGATIVE_INFINITY || number == Float.MAX_VALUE) {
            throw new ArithmeticException();
        }
        return Math.nextAfter(number, Float.POSITIVE_INFINITY);
    }

    @Override
    public float nextDown(float number) {
        if (number == Float.POSITIVE_INFINITY || number == Float.NEGATIVE_INFINITY || number == Float.MIN_VALUE) {
            throw new ArithmeticException();
        }
        return Math.nextAfter(number, Float.NEGATIVE_INFINITY);
    }
}
