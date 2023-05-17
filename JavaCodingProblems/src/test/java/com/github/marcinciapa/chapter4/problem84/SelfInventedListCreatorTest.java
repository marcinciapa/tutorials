package com.github.marcinciapa.chapter4.problem84;

class SelfInventedListCreatorTest extends ListCreatorTest<SelfInventedListCreator> {

    @Override
    SelfInventedListCreator creator(int val1, int val2, int val3) {
        return new SelfInventedListCreator(val1, val2, val3);
    }
}
