package com.github.marcinciapa.chapter1.problem13;

class SelfIncentedCharacterRemoverTest implements CharacterRemoverTest<SelfInventedCharacterRemover> {

    @Override
    public SelfInventedCharacterRemover createInstance() {
        return new SelfInventedCharacterRemover();
    }
}
