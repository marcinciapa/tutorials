package com.github.marcinciapa.chapter5.problem113;

import java.util.HashMap;
import java.util.Map;

class MapReplacer {

    private final Map<String, Integer> map;

    MapReplacer(Map<String, Integer> map) {
        this.map = new HashMap<>(map);
    }

    void replaceByKey(String key, Integer newValue) {
        map.replace(key, newValue);
    }

    void replaceByKeyValue(String key, Integer value, Integer newValue) {
        map.replace(key, value, newValue);
    }

    public void replaceByValue(Integer value, Integer newValue) {
        map.replaceAll((key, val) -> value.equals(val) ? newValue : val);
    }

    Map<String, Integer> map() {
        return map;
    }
}
