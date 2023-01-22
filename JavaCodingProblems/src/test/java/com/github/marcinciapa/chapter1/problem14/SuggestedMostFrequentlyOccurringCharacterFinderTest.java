package com.github.marcinciapa.chapter1.problem14;

class SuggestedMostFrequentlyOccurringCharacterFinderTest
        implements MostFrequentlyOccurringCharacterFinderTest<SuggestedMostFrequentlyOccurringCharacterFinder> {

    @Override
    public SuggestedMostFrequentlyOccurringCharacterFinder createInstance() {
        return new SuggestedMostFrequentlyOccurringCharacterFinder();
    }
}
