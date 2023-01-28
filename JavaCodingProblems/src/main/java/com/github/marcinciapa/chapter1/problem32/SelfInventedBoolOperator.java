package com.github.marcinciapa.chapter1.problem32;

class SelfInventedBoolOperator implements BoolOperator {

    @Override
    public boolean and(boolean x, boolean y) {
        return x && y;
    }

    @Override
    public boolean or(boolean x, boolean y) {
        return x || y;
    }

    @Override
    public boolean xor(boolean x, boolean y) {
        return x ^ y;
    }
}
