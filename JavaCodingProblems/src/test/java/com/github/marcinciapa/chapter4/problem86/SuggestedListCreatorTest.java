package com.github.marcinciapa.chapter4.problem86;

class SuggestedListCreatorTest extends ListCreatorTest<SuggestedListCreator> {

    @Override
    SuggestedListCreator creator(int... vals) {
        return new SuggestedListCreator(vals);
    }
}
