package com.github.marcinciapa.chapter1.problem5;

import java.util.List;

import static java.util.Objects.isNull;

class SelfInventedLettersCounter implements LettersCounter {

    private static final List<Character> VOWELS = List.of(
            'a', 'e', 'i', 'o', 'u', 'y'
    );
    private static final List<Character> CONSONANTS = List.of(
            'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'
    );

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
        return (int) testedString.toLowerCase().chars()
                .mapToObj(letter -> (char) letter)
                .filter(referenceList::contains)
                .count();
    }
}
