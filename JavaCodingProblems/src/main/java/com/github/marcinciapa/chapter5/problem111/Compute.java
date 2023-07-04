package com.github.marcinciapa.chapter5.problem111;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

class Compute {

    private final Map<String, Integer> map;

    Compute(Map<String, Integer> map) {
        this.map = new HashMap<>(map);
    }

    int incrementAndGet(String key) {
        return map.compute(key, (k, v) -> isNull(v) ? 0 : v + 1);
    }
}
