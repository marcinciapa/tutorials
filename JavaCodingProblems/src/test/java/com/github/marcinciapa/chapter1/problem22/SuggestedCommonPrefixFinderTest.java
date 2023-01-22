package com.github.marcinciapa.chapter1.problem22;

class SuggestedCommonPrefixFinderTest extends CommonPrefixFinderTest<SuggestedCommonPrefixFinder> {

    @Override
    protected SuggestedCommonPrefixFinder createInstance() {
        return new SuggestedCommonPrefixFinder();
    }
}
