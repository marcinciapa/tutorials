package com.github.marcinciapa._2;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class FirstNotDuplicatedCharacterFinder {

    /**
     * Creates a map with char count with first inputString traverse
     * Checks if the char occurs once with inputString traverse
     * @param inputString
     * @return
     */
    Optional<Character> selfInventedSolution(String inputString) {
        if (isNull(inputString)) {
            return Optional.empty();
        }

        Map<Character, Long> charWithOccurrenceCount = inputString.chars()
                .mapToObj(character -> (char) character)
                .collect(groupingBy(c -> c, counting()));
        return firstNotDuplicatedChar(inputString, charWithOccurrenceCount);
    }

    private final int MAX_ASCII_CODE = 256;
    private final int NOT_EXISTS_STATE = -1;
    private final int DUPLICATED_STATE = -2;

    /**
     * For each possible character creates an array of NOT_EXISTS state
     * With inputString traverse, sets index of char of string if state is NOT_EXISTS, or DUPLICATE state if index already assigned to char
     * Than traverses the all possible chars array searching for the minimal index of occurrence of this char in the inputString
     * @param inputString
     * @return
     */
    Optional<Character> suggestedSolution1(String inputString) {

        if(isNull(inputString)) {
            return Optional.empty();
        }

        int[] occurrenceIndexOrState = new int[MAX_ASCII_CODE];
        Arrays.fill(occurrenceIndexOrState, NOT_EXISTS_STATE);

        for (int i = 0; i < inputString.length(); ++i) {
            int codePoint = inputString.codePointAt(i);
            occurrenceIndexOrState[codePoint] = occurrenceIndexOrState[codePoint] == NOT_EXISTS_STATE
                    ? i
                    : DUPLICATED_STATE;
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < MAX_ASCII_CODE; ++i) {
            if (occurrenceIndexOrState[i] != NOT_EXISTS_STATE && occurrenceIndexOrState[i] != DUPLICATED_STATE) {
                position = Math.min(position, occurrenceIndexOrState[i]);
            }
        }

        return position < Integer.MAX_VALUE ? Optional.of(inputString.charAt(position)) : Optional.empty();
    }

    /**
     * With single travers of the inputString puts the count of the character to LinkedHashMap (preserving order)
     * Than searches for the first character in the LinkedHashMap, that has occurrence count exactly 1.
     * @param inputString
     * @return
     */
    Optional<Character> suggestedSolution2(String inputString) {
        if(isNull(inputString)) {
            return Optional.empty();
        }
        LinkedHashMap<Character, Integer> charOccurrences = new LinkedHashMap<>();
        for(int i=0; i<inputString.length(); ++i) {
            char nextCharacter = inputString.charAt(i);
            charOccurrences.putIfAbsent(nextCharacter, 0);
            charOccurrences.compute(nextCharacter, (character, count) -> ++count);
        }
        return charOccurrences.entrySet()
                .stream()
                .filter(charOccurrence -> charOccurrence.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey);
    }

    private static Optional<Character> firstNotDuplicatedChar(String inputString, Map<Character, Long> charWithOccurrenceCount) {
        return inputString.chars()
                .mapToObj(character -> (char) character)
                .filter(character -> charWithOccurrenceCount.get(character) == 1)
                .findFirst();
    }

}
