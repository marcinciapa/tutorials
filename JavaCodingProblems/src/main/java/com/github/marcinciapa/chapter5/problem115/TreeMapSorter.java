package com.github.marcinciapa.chapter5.problem115;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Comparator.comparing;

class TreeMapSorter implements MapSorter {

    @Override
    public Map<AlphabetChar, Character> sorted(Map<AlphabetChar, Character> unsortedMap) {
        TreeMap<AlphabetChar, Character> treeMap = new TreeMap<>(comparing(AlphabetChar::place));
        treeMap.putAll(unsortedMap);
        return treeMap;
    }
}
