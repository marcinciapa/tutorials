package com.github.marcinciapa.chapter4.problem83;

import java.util.Arrays;
import java.util.List;

class SelfInventedListCreator implements ListCreator {

    private final List<Integer> vals;

    SelfInventedListCreator(int... vals) {
        this.vals = Arrays.stream(vals).boxed().toList();
    }

    @Override
    public List<Integer> toList() {
        return vals;
    }
}
