package com.github.marcinciapa.chapter1.problem14;

class SelfInventedMostFrequentlyOccurringCharacterFinderTest
        implements MostFrequentlyOccurringCharacterFinderTest<SelfInventedMostFrequentlyOccurringCharacterFinder> {

    @Override
    public SelfInventedMostFrequentlyOccurringCharacterFinder createInstance() {
        return new SelfInventedMostFrequentlyOccurringCharacterFinder();
    }
}
