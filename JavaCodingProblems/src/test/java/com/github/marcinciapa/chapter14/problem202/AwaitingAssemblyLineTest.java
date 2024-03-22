package com.github.marcinciapa.chapter14.problem202;

import com.github.marcinciapa.chapter14.bulbs.AssemblyLineTest;

class AwaitingAssemblyLineTest extends AssemblyLineTest<AwaitingAssemblyLine> {

    @Override
    protected AwaitingAssemblyLine assemblyLine() {
        return new AwaitingAssemblyLine();
    }
}