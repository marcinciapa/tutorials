package com.github.marcinciapa.chapter2.problem41;

class SelfInventedNullCheckerTest extends NullCheckerTest<SelfInventedNullChecker> {

    @Override
    SelfInventedNullChecker createChecker() {
        return new SelfInventedNullChecker();
    }
}
