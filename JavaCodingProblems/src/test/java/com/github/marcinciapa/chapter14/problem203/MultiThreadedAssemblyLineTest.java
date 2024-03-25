package com.github.marcinciapa.chapter14.problem203;

import com.github.marcinciapa.chapter14.bulbs.AssemblyLineTest;

class MultiThreadedAssemblyLineTest extends AssemblyLineTest<MultiThreadedAssemblyLine> {

    @Override
    protected MultiThreadedAssemblyLine assemblyLine() {
        return new MultiThreadedAssemblyLine();
    }
}