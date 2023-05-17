package com.github.marcinciapa.chapter4.problem84;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

class SelfInventedListCreator implements ListCreator {

    private final List<Integer> vals;

    public SelfInventedListCreator(int... vals) {
        this.vals = stream(vals).boxed().toList();
    }

    @Override
    public List<Integer> toList() {
        var newList = new ArrayList<>(vals);
        return newList;
    }
}
