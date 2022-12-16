package com.github.marcinciapa._9;

class SelfInventedStringsJoinerTest implements StringsJoinerTest<SelfInventedStringsJoiner> {
    @Override
    public SelfInventedStringsJoiner createJoiner() {
        return new SelfInventedStringsJoiner();
    }
}
