package com.github.marcinciapa.chapter1.problem16;

class SelfInventedSubstringFinderTest implements SubstringFinderTest<SelfInventedSubstringFinder> {

    @Override
    public SelfInventedSubstringFinder getInstance() {
        return new SelfInventedSubstringFinder();
    }
}
