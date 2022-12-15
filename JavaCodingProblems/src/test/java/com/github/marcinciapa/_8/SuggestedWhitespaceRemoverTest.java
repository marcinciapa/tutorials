package com.github.marcinciapa._8;

class SuggestedWhitespaceRemoverTest implements WhitespaceRemoverTest<SuggestedWhitespaceRemover> {

    @Override
    public SuggestedWhitespaceRemover createRemover() {
        return new SuggestedWhitespaceRemover();
    }
}
