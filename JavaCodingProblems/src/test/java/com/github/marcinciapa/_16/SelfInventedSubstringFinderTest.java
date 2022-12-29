package com.github.marcinciapa._16;

class SelfInventedSubstringFinderTest implements SubstringFinderTest<SelfInventedSubstringFinder> {

    @Override
    public SelfInventedSubstringFinder getInstance() {
        return new SelfInventedSubstringFinder();
    }
}
