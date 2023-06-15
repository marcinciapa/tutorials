package com.github.marcinciapa.chapter5.problem101;

class Jdk9MismatchFinderTest extends ArrayMismatchFinderTest<Jdk9MismatchFinder> {

    @Override
    Jdk9MismatchFinder mismatchFinder() {
        return new Jdk9MismatchFinder();
    }
}
