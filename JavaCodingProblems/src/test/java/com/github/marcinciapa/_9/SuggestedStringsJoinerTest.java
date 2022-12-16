package com.github.marcinciapa._9;

class SuggestedStringsJoinerTest implements StringsJoinerTest<SuggestedStringsJoiner> {
    @Override
    public SuggestedStringsJoiner createJoiner() {
        return new SuggestedStringsJoiner();
    }
}
