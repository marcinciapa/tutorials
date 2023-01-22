package com.github.marcinciapa.chapter1.problem22;

class SelfInventedCommonPrefixFinderTest extends CommonPrefixFinderTest<SelfInventedCommonPrefixFinder> {

    @Override
    protected SelfInventedCommonPrefixFinder createInstance() {
        return new SelfInventedCommonPrefixFinder();
    }
}
