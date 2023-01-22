package com.github.marcinciapa.chapter1.problem12;

class SelfInventedCharacterDeduplicatorTest implements CharacterDeduplicatorTest<SelfInventedCharacterDeduplicator> {

    @Override
    public SelfInventedCharacterDeduplicator createInstance() {
        return new SelfInventedCharacterDeduplicator();
    }
}
