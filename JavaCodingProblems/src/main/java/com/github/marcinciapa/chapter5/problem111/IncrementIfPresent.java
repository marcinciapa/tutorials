package com.github.marcinciapa.chapter5.problem111;

import java.util.HashMap;
import java.util.Map;

class IncrementIfPresent {

    private final Map<String, Integer> map;

    IncrementIfPresent(Map<String, Integer> initialMap) {
        this.map = new HashMap<>(initialMap);
    }

    void incrementIfPresent(String mapKey) {
        map.computeIfPresent(mapKey, (key, value) -> value + 1);
    }

    public Map<String, Integer> map() {
        return map;
    }
}
