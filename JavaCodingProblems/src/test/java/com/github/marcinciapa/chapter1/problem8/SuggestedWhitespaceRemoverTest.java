package com.github.marcinciapa.chapter1.problem8;

class SuggestedWhitespaceRemoverTest implements WhitespaceRemoverTest<SuggestedWhitespaceRemover> {

    @Override
    public SuggestedWhitespaceRemover createRemover() {
        return new SuggestedWhitespaceRemover();
    }
}
