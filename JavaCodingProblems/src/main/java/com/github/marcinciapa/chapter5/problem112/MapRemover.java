package com.github.marcinciapa.chapter5.problem112;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static java.util.Objects.isNull;

class MapRemover {

    private final Map<Integer, String> map;

    MapRemover(Map<Integer, String> map) {
        this.map = new HashMap<>(map);
    }

    void removeByKey(Integer key) {
        if (isNull(key)) {
            throw new IllegalArgumentException();
        }
        map.remove(key);
    }

    void removeByKeyValue(Integer key, String value) {
        if (isNull(key) || isNull(value)) {
            throw new IllegalArgumentException();
        }
        map.remove(key, value);
    }

    void removeByValue(String value) {
        if (isNull(value)) {
            throw new IllegalArgumentException();
        }
        map.entrySet().removeIf(entry -> value.equals(entry.getValue()));
    }

    Map<Integer, String> map() {
        return unmodifiableMap(map);
    }
}
