package com.github.marcinciapa.chapter1.problem31;

class SelfInventedSiFiniteCheckerTest extends IsFiniteCheckerTest<SelfInventedIsFiniteChecker> {

    @Override
    IsFiniteChecker createInstance() {
        return new SelfInventedIsFiniteChecker();
    }
}
