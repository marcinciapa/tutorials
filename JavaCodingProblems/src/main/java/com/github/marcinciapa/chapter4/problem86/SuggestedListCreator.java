package com.github.marcinciapa.chapter4.problem86;

import java.util.List;

import static java.util.Arrays.stream;

class SuggestedListCreator implements ListCreator {

    private final List<Integer> vals;

    SuggestedListCreator(int... vals) {
        this.vals = stream(vals).boxed().toList();
    }

    @Override
    public List<Integer> toList() {
        return this.vals;
    }
}
