package com.github.marcinciapa.chapter4.problem87;

class TrapezoidImplTest extends TrapezoidTest<TrapezoidImpl> {

    @Override
    TrapezoidImpl calculator(int a, int b, int h) {
        return new TrapezoidImpl(a, b, h);
    }
}
