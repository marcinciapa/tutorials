package com.github.marcinciapa.chapter2.problem42;

class SelfInventedNullChecker implements NullChecker {

    @Override
    public <T> T requireNonNullOrThrow(T object) {
        if(object == null) {
            throw new IllegalArgumentException();
        }
        return object;
    }
}
