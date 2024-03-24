package com.github.marcinciapa.chapter14.problem202;

import com.github.marcinciapa.chapter14.bulbs.AssemblyLineTest;

class NonBlockingAssemblyLineTest extends AssemblyLineTest<NonBlockingAssemblyLine> {

    @Override
    protected NonBlockingAssemblyLine assemblyLine() {
        return new NonBlockingAssemblyLine();
    }
}