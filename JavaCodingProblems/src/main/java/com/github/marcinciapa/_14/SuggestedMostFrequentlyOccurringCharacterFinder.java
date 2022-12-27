package com.github.marcinciapa._14;

import java.util.Optional;

import static java.lang.Math.min;
import static java.util.Objects.isNull;

class SuggestedMostFrequentlyOccurringCharacterFinder implements MostFrequentlyOccurringCharacterFinder {

    private static final int EXTENDED_ASCII_SIZE = 256;

    @Override
    public Optional<Character> findMostFrequentlyOccurringCharacter(String inputString) {
        if (isNull(inputString)) {
            return Optional.empty();
        }

        char mostOccurringCharacter = Character.MAX_VALUE;
        int maxOccurrences = 0;

        int[] occurrences = new int[EXTENDED_ASCII_SIZE];

        for (char character : inputString.toCharArray()) {
            occurrences[character]++;
            if (occurrences[character] >= maxOccurrences) {
                maxOccurrences = occurrences[character];
                mostOccurringCharacter = (char)min(character, mostOccurringCharacter);
            }
        }

        return maxOccurrences > 0 ? Optional.of(mostOccurringCharacter) : Optional.empty();
    }
}
