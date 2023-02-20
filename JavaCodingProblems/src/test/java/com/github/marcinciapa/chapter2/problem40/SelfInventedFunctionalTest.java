package com.github.marcinciapa.chapter2.problem40;

class SelfInventedFunctionalTest extends NullCheckerTest<SelfInventedFunctional> {

    @Override
    SelfInventedFunctional createChecker() {
        return new SelfInventedFunctional();
    }
}
