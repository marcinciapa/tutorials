package com.github.marcinciapa.chapter5.problem117;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

class MapMerger {


    public Map<String, Integer> merge(Map<String, Integer> leftMap, Map<String, Integer> rightMap) {
        if (isNull(leftMap) || isNull(rightMap)) {
            throw new IllegalArgumentException();
        }

        HashMap<String, Integer> merged = new HashMap<>(leftMap);
        rightMap.entrySet().forEach(
                entry -> mergeInto(merged, entry)
        );
        return merged;
    }

    private void mergeInto(Map<String, Integer> merged, Map.Entry<String, Integer> entry) {
        merged.merge(entry.getKey(), entry.getValue(), (vLeft, vRight) -> vRight);
    }
}
