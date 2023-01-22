package com.github.marcinciapa.chapter1.problem9;

class SuggestedStringsJoinerTest implements StringsJoinerTest<SuggestedStringsJoiner> {
    @Override
    public SuggestedStringsJoiner createJoiner() {
        return new SuggestedStringsJoiner();
    }
}
