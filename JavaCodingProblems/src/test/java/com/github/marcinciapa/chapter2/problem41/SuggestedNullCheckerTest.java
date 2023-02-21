package com.github.marcinciapa.chapter2.problem41;

class SuggestedNullCheckerTest extends NullCheckerTest<SuggestedNullChecker> {

    @Override
    SuggestedNullChecker createChecker() {
        return new SuggestedNullChecker();
    }
}
