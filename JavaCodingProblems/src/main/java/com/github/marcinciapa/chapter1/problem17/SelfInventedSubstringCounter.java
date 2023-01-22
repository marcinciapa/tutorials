package com.github.marcinciapa.chapter1.problem17;

import static java.util.Objects.isNull;

class SelfInventedSubstringCounter implements SubstringCounter {

    @Override
    public int countSubstringOccurrences(String inputString, String substring) {
        if (isNull(inputString) || isNull(substring) || substring.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return substringOccurrencesAfterPosition(0, inputString, substring);
    }

    private int substringOccurrencesAfterPosition(int position, String inputString, String substring) {
        int indexOfSubstring = inputString.indexOf(substring, position);
        if (indexOfSubstring < 0) {
            return 0;
        }
        return 1 + substringOccurrencesAfterPosition(indexOfSubstring + 1, inputString, substring);
    }
}
