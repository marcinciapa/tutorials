package com.github.marcinciapa.chapter4.problem83;

class SelfInventedListCreatorTest extends ListCreatorTest<SelfInventedListCreator> {

    @Override
    SelfInventedListCreator creator(int val0, int val1, int val2) {
        return new SelfInventedListCreator(val0, val1, val2);
    }
}
