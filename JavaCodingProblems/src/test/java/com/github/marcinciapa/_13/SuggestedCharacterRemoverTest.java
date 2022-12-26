package com.github.marcinciapa._13;

class SuggestedCharacterRemoverTest implements CharacterRemoverTest<SuggestedCharacterRemover> {

    @Override
    public SuggestedCharacterRemover createInstance() {
        return new SuggestedCharacterRemover();
    }
}
