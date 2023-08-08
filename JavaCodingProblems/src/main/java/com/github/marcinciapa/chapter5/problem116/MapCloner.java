package com.github.marcinciapa.chapter5.problem116;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

class MapCloner {

    <K, V> Map<K, V> clone(Map<K, V> map) {
        if (isNull(map)) {
            throw new IllegalArgumentException();
        }
        return new HashMap<>(map);
    }
}
