package com.github.marcinciapa.chapter14.problem201;

import java.util.HashMap;
import java.util.Map;

class MapWrapper {

    private final Map<String, Integer> map = new HashMap<>();

    void increment(String key) {
        map.compute(key, (k, v) -> v == null ? 1 : ++v);
    }

    int cumulatedValues() {
        return map.values()
                .stream()
                .reduce(0, Integer::sum);
    }

    int countKeys() {
        return map.keySet().size();
    }
}
