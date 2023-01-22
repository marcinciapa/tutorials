package com.github.marcinciapa.chapter1.problem9;

class SelfInventedStringsJoinerTest implements StringsJoinerTest<SelfInventedStringsJoiner> {
    @Override
    public SelfInventedStringsJoiner createJoiner() {
        return new SelfInventedStringsJoiner();
    }
}
