package com.github.marcinciapa.chapter5.problem110;

import java.util.Map;

import static java.util.Objects.isNull;

class Java8DefaultExtractor implements DefaultExtractor {

    private final Map<String, Integer> map;

    Java8DefaultExtractor(Map<String, Integer> map) {
        if(isNull(map)) {
            throw new IllegalArgumentException();
        }
        this.map = map;
    }

    @Override
    public Integer extract(String s) {
        return map.getOrDefault(s, 0);
    }
}
