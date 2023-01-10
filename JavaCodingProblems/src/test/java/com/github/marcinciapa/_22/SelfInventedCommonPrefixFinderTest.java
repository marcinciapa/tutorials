package com.github.marcinciapa._22;

class SelfInventedCommonPrefixFinderTest extends CommonPrefixFinderTest<SelfInventedCommonPrefixFinder> {

    @Override
    protected SelfInventedCommonPrefixFinder createInstance() {
        return new SelfInventedCommonPrefixFinder();
    }
}
