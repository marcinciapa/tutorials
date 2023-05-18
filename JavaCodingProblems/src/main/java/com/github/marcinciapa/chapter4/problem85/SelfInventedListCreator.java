package com.github.marcinciapa.chapter4.problem85;

import java.util.List;

import static java.util.Arrays.stream;

class SelfInventedListCreator implements ListCreator {

    private final List<Integer> vals;

    SelfInventedListCreator(int[] vals) {
        this.vals = stream(vals).boxed().toList();
    }

    @Override
    public List<Integer> toList() {
        return vals;
    }
}
