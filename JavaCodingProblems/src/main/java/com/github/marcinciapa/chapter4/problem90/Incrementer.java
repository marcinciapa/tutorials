package com.github.marcinciapa.chapter4.problem90;

import java.util.List;
import java.util.stream.Stream;

class Incrementer {

    private final List<Integer> initialList;

    Incrementer(List<Integer> initialList) {
        this.initialList = initialList;
    }

    List<Integer> increment() {
        var stream = initialList.stream();
        stream = stream.map(i -> i+1);
        return stream.toList();
    }
}
