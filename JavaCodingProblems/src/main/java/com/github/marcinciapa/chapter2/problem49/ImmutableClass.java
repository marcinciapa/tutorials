package com.github.marcinciapa.chapter2.problem49;

final class ImmutableClass {

    private final int x;
    private final int y;

    ImmutableClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }
}
