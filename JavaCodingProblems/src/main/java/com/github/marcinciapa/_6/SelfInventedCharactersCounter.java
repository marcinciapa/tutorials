package com.github.marcinciapa._6;

import static java.util.Objects.isNull;

class SelfInventedCharactersCounter implements CharacterCounter {

    @Override
    public int countOccurrencesOf(char countedCharacter, String testedString) {
        if (isNull(testedString)) {
            throw new IllegalArgumentException("Tested string cannot be null");
        }

        return (int) testedString.chars()
                .filter(testedChar -> testedChar == countedCharacter)
                .count();
    }
}
