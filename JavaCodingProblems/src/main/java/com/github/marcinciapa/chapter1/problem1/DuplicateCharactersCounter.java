package com.github.marcinciapa.chapter1.problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyMap;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class DuplicateCharactersCounter {

    Map<String, Long> selfWrittenSolution(String inputString) {
        if (isNull(inputString)) {
            return emptyMap();
        }
        HashMap<String, Long> foundCharacterWithCount = new HashMap<>();
        for(int i=0; i<inputString.length(); ++i) {
            int charUnicode = inputString.codePointAt(i);
            if(Character.toChars(charUnicode).length == 2) {
                ++i;
            }
            String character = String.valueOf(Character.toChars(charUnicode));
            foundCharacterWithCount.putIfAbsent(character, 0L);
            foundCharacterWithCount.computeIfPresent(
                    character,
                    (key, count) -> count + 1
            );
        }
        return withoutSingleOccurrences(foundCharacterWithCount);
    }

    Map<String, Long> suggestedSolution(String inputString) {
        if (isNull(inputString)) {
            return emptyMap();
        }
        Map<String, Long> foundCharsWithCount = inputString.codePoints()
                .mapToObj(character -> String.valueOf(Character.toChars(character)))
                .collect(groupingBy(c -> c, counting()));
        return withoutSingleOccurrences(foundCharsWithCount);
    }

    private static Map<String, Long> withoutSingleOccurrences(Map<String, Long> foundCharacterWithCount) {
        return foundCharacterWithCount.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
