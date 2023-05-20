package com.github.marcinciapa.chapter4.problem87;

class TrapezoidImpl implements Trapezoid {

    private final int a;
    private final int b;
    private final int h;

    TrapezoidImpl(int a, int b, int h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    @Override
    public int area() {
        var bars = a + b;
        var rectangle = bars * h;
        var area = rectangle / 2;
        return area;
    }
}
