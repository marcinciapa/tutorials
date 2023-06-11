package com.github.marcinciapa.chapter5.problem100;

class SelfInventedCheckerTest extends ElementCheckerTest<SelfInventedChecker> {

    @Override
    SelfInventedChecker checker() {
        return new SelfInventedChecker();
    }
}
