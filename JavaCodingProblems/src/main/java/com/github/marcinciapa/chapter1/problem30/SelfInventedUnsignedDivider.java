package com.github.marcinciapa.chapter1.problem30;

class SelfInventedUnsignedDivider implements UnsignedDivider {

    @Override
    public long divide(int dividend, int divisor) {
        return Integer.toUnsignedLong(Integer.divideUnsigned(dividend, divisor));
    }

    @Override
    public long modulo(int dividend, int divisor) {
        return Integer.toUnsignedLong(Integer.remainderUnsigned(dividend, divisor));
    }
}
