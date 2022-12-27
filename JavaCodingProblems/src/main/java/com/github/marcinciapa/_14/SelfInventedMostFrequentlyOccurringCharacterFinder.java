package com.github.marcinciapa._14;

import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class SelfInventedMostFrequentlyOccurringCharacterFinder implements MostFrequentlyOccurringCharacterFinder {

    @Override
    public Optional<Character> findMostFrequentlyOccurringCharacter(String inputString) {
        if (isNull(inputString)) {
            return Optional.empty();
        }

        Map<Character, Long> charsGroupedByCount = groupCharsByCount(inputString);
        return getOptionalMostOccurringCharacterWithCount(charsGroupedByCount)
                .map(Map.Entry::getKey);
    }

    private Map<Character, Long> groupCharsByCount(String inputString) {
        return inputString.chars()
                .mapToObj(character -> (char) character)
                .collect(groupingBy(identity(), counting()));
    }

    private Optional<Map.Entry<Character, Long>> getOptionalMostOccurringCharacterWithCount(
            Map<Character, Long> charsGroupedByCount) {

        return charsGroupedByCount.entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }
}
