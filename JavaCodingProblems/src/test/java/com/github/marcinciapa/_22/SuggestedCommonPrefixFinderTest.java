package com.github.marcinciapa._22;

class SuggestedCommonPrefixFinderTest extends CommonPrefixFinderTest<SuggestedCommonPrefixFinder> {

    @Override
    protected SuggestedCommonPrefixFinder createInstance() {
        return new SuggestedCommonPrefixFinder();
    }
}
