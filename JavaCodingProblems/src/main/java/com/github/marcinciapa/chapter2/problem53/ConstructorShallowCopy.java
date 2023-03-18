package com.github.marcinciapa.chapter2.problem53;

class ConstructorShallowCopy {

    private final double x;
    private final double y;

    ConstructorShallowCopy(double x, double y) {
        this.x = x;
        this.y = y;
    }

    ConstructorShallowCopy(ConstructorShallowCopy original) {
        this(original.x(), original.y());
    }

    double x() {
        return this.x;
    }

    double y() {
        return this.y;
    }
}
