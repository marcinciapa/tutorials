package com.github.marcinciapa.chapter5.problem107;

class SelfInventedNgeFinderTest extends NgeFinderTest<SelfInventedNgeFinder> {

    @Override
    SelfInventedNgeFinder ngeFinder() {
        return new SelfInventedNgeFinder();
    }
}
