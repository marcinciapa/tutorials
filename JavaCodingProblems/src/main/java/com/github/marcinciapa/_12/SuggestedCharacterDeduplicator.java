package com.github.marcinciapa._12;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;

class SuggestedCharacterDeduplicator implements CharacterDeduplicator {

    @Override
    public String removeDuplicateChars(String inputString) {
        if(isNull(inputString)) {
            return null;
        }

        StringBuilder deduplicatedChars = new StringBuilder();
        Set<Character> charOccurrences = new HashSet<>();

        for(char character : inputString.toCharArray()) {
            if(charOccurrences.add(character)) {
                deduplicatedChars.append(character);
            }
        }

        return deduplicatedChars.toString();
    }
}
