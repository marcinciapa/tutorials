package com.github.marcinciapa.chapter5.problem119;

import java.util.List;

import static java.util.Objects.isNull;

class CollectionToArrayConverter {

    String[] toArray(List<String> objects) {
        if (isNull(objects)) {
            throw new IllegalArgumentException();
        }
        return objects.toArray(String[]::new);
    }
}
