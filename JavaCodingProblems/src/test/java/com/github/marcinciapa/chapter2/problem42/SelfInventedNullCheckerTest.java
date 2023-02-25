package com.github.marcinciapa.chapter2.problem42;

class SelfInventedNullCheckerTest extends NullCheckerTest<SelfInventedNullChecker> {

    @Override
    SelfInventedNullChecker createInstance() {
        return new SelfInventedNullChecker();
    }
}
