package com.github.marcinciapa.chapter5.problem100;

class SelfInventedFinderTest extends ElementFinderTest<SelfInventedFinder> {

    @Override
    SelfInventedFinder finder() {
        return new SelfInventedFinder();
    }
}
