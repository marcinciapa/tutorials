package com.github.marcinciapa._13;

class SelfIncentedCharacterRemoverTest implements CharacterRemoverTest<SelfInventedCharacterRemover> {

    @Override
    public SelfInventedCharacterRemover createInstance() {
        return new SelfInventedCharacterRemover();
    }
}
