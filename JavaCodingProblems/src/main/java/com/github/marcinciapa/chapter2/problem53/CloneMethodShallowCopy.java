package com.github.marcinciapa.chapter2.problem53;

class CloneMethodShallowCopy extends CloneMethodIntermediateClass implements Cloneable {

    private double x;
    private double y;

    CloneMethodShallowCopy(double x, double y, double z) {
        super(z);
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    @Override
    public CloneMethodShallowCopy clone() throws CloneNotSupportedException {
        return (CloneMethodShallowCopy) super.clone();
    }
}
