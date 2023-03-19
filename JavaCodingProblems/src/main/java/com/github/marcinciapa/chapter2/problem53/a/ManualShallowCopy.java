package com.github.marcinciapa.chapter2.problem53.a;

class ManualShallowCopy {

    private double x;
    private double y;

    ManualShallowCopy() {
    }

    ManualShallowCopy(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    ManualShallowCopy copy() {
        ManualShallowCopy copy = new ManualShallowCopy();
        copy.x = this.x;
        copy.y = this.y;
        return copy;
    }
}
