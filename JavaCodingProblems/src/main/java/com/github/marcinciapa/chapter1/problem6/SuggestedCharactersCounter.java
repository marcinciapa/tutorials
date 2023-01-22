package com.github.marcinciapa.chapter1.problem6;

import static java.util.Objects.isNull;

class SuggestedCharactersCounter implements CharacterCounter {

    @Override
    public int countOccurrencesOf(char countedCharacter, String testedString) {
        if(isNull(testedString)) {
            throw new IllegalArgumentException("Tested string cannot be null");
        }
        String stringWithCountedCharRemoved = testedString.replaceAll(String.valueOf(countedCharacter), "");
        return testedString.length() - stringWithCountedCharRemoved.length();
    }
}
