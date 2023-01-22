package com.github.marcinciapa.chapter1.problem13;

class SuggestedCharacterRemoverTest implements CharacterRemoverTest<SuggestedCharacterRemover> {

    @Override
    public SuggestedCharacterRemover createInstance() {
        return new SuggestedCharacterRemover();
    }
}
