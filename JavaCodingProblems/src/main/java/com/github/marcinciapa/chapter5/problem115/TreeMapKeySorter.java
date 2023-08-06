package com.github.marcinciapa.chapter5.problem115;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Comparator.comparing;

class TreeMapKeySorter implements MapKeySorter {

    @Override
    public Map<DigitalNumber, WrittenNumber> sortedByKey(Map<DigitalNumber, WrittenNumber> unsortedMap) {
        TreeMap<DigitalNumber, WrittenNumber> treeMap = new TreeMap<>(comparing(DigitalNumber::number));
        treeMap.putAll(unsortedMap);
        return treeMap;
    }
}
