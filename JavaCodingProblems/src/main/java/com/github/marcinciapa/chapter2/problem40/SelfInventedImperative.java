package com.github.marcinciapa.chapter2.problem40;

class SelfInventedImperative implements NullChecker {

    @Override
    public boolean isNull(Object object) {
        return object == null;
    }
}
