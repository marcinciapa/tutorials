package com.github.marcinciapa._5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

class SuggestedLettersCounter implements LettersCounter {

    private static final List<Character> VOWELS = List.of(
            'a', 'e', 'i', 'o', 'u', 'y'
    );
    private static final List<Character> CONSONANTS = List.of(
            'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'
    );
    private static final boolean CONTAINED_IN_LIST = true;

    @Override
    public int countVowels(String inputString) {
        return countLettersContainedIn(VOWELS, inputString);
    }

    @Override
    public int countConsonants(String inputString) {
        return countLettersContainedIn(CONSONANTS, inputString);
    }

    private int countLettersContainedIn(List<Character> referenceList, String testedString) {
        if (isNull(testedString)) {
            return 0;
        }
        Map<Boolean, Long> containsIndicatorWithCounts = testedString.toLowerCase().chars()
                .mapToObj(letter -> (char) letter)
                .filter(letter -> letter >= 'a' && letter <= 'z')
                .collect(Collectors.partitioningBy(referenceList::contains, Collectors.counting()));

        return containsIndicatorWithCounts.get(CONTAINED_IN_LIST).intValue();
    }
}
