package com.github.marcinciapa.chapter1.problem12;

class SuggestedCharacterDeduplicatorTest implements CharacterDeduplicatorTest<SuggestedCharacterDeduplicator> {

    @Override
    public SuggestedCharacterDeduplicator createInstance() {
        return new SuggestedCharacterDeduplicator();
    }
}
