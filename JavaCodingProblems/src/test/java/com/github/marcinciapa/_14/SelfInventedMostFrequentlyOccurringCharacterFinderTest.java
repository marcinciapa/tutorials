package com.github.marcinciapa._14;

class SelfInventedMostFrequentlyOccurringCharacterFinderTest
        implements MostFrequentlyOccurringCharacterFinderTest<SelfInventedMostFrequentlyOccurringCharacterFinder> {

    @Override
    public SelfInventedMostFrequentlyOccurringCharacterFinder createInstance() {
        return new SelfInventedMostFrequentlyOccurringCharacterFinder();
    }
}
