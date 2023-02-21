package com.github.marcinciapa.chapter2.problem41;

class SelfInventedNullChecker implements NullChecker {

    @Override
    public void checkNotNull(Object object) {
        if (object == null) {
            throw new NullPointerException("Argument cannot be null");
        }
    }
}
