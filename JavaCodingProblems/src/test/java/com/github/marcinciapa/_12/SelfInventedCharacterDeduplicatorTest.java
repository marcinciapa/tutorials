package com.github.marcinciapa._12;

class SelfInventedCharacterDeduplicatorTest implements CharacterDeduplicatorTest<SelfInventedCharacterDeduplicator> {

    @Override
    public SelfInventedCharacterDeduplicator createInstance() {
        return new SelfInventedCharacterDeduplicator();
    }
}
