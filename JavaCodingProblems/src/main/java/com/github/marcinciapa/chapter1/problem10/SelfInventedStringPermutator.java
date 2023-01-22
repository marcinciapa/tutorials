package com.github.marcinciapa.chapter1.problem10;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static java.util.Objects.isNull;

class SelfInventedStringPermutator implements StringPermutator {

    @Override
    public List<String> generatePermutations(String input) {
        if (isNull(input)) {
            throw new NullPointerException();
        }

        // Recursive problem
        return getPermutations(input);
    }

    List<String> getPermutations(String input) {
        if(input.length() == 1) {
            return singletonList(input);
        }

        List<String> permutations = new LinkedList<>();

        Set<Character> startingLetters = getUniqueStartingLetters(input);

        for(Character letter : startingLetters) {
            String stringWithLetterExcluded = getStringWithLetterExcluded(letter, input);
            List<String> afterLetterPermutations = getPermutations(stringWithLetterExcluded);
            afterLetterPermutations.stream()
                    .map(permutation -> letter + permutation)
                    .forEach(permutations::add);
        }

        return permutations;
    }

    private String getStringWithLetterExcluded(Character letter, String input) {
        int letterIndex = input.indexOf(letter);
        String substringBeforeLetter = input.substring(0, letterIndex);
        String substringAfterLetter = input.substring(letterIndex + 1);
        return substringBeforeLetter + substringAfterLetter;
    }

    private Set<Character> getUniqueStartingLetters(String input) {
        return input.chars()
                .mapToObj(letter -> (char) letter)
                .collect(Collectors.toSet());
    }
}
