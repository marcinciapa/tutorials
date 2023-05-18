package com.github.marcinciapa.chapter4.problem85;

class SelfInventedListCreatorTest extends ListCreatorTest<SelfInventedListCreator> {

    @Override
    SelfInventedListCreator creator(int[] vals) {
        return new SelfInventedListCreator(vals);
    }
}
