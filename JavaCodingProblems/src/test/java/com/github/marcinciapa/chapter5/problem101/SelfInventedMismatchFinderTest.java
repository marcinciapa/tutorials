package com.github.marcinciapa.chapter5.problem101;

class SelfInventedMismatchFinderTest extends ArrayMismatchFinderTest<SelfInventedMismatchFinder> {

    @Override
    SelfInventedMismatchFinder mismatchFinder() {
        return new SelfInventedMismatchFinder();
    }
}
