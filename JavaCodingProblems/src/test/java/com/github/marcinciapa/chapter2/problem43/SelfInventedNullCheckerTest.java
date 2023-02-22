package com.github.marcinciapa.chapter2.problem43;

class SelfInventedNullCheckerTest extends NullCheckerTest<SelfInventedNullChecker> {

    @Override
    SelfInventedNullChecker createInstance() {
        return new SelfInventedNullChecker();
    }
}
