package com.github.marcinciapa.chapter5.problem115;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toMap;

class StreamSorter implements MapKeySorter, MapValueSorter {

    @Override
    public Map<DigitalNumber, WrittenNumber> sortedByKey(Map<DigitalNumber, WrittenNumber> unsortedMap) {
        return unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(comparing(DigitalNumber::number)))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new)
                );
    }

    @Override
    public Map<DigitalNumber, WrittenNumber> sortedByValue(Map<DigitalNumber, WrittenNumber> unsortedMap) {
        return unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparing(WrittenNumber::number)))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1,
                        LinkedHashMap::new
                ));
    }
}
