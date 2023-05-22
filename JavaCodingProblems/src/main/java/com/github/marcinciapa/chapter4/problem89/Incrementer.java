package com.github.marcinciapa.chapter4.problem89;

import java.util.ArrayList;
import java.util.List;

class Incrementer {

    private final List<Integer> elements;

    Incrementer(List<Integer> elements) {
        this.elements = elements;
    }

    List<Integer> increment() {
        List<Integer> incrementedElements = new ArrayList<>();
        for(var element: elements) {
            incrementedElements.add(element + 1);
        }
        return incrementedElements;
    }
}
