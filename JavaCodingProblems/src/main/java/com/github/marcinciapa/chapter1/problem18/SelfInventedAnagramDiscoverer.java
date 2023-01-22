package com.github.marcinciapa.chapter1.problem18;

import static java.util.Objects.isNull;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.joining;

class SelfInventedAnagramDiscoverer implements AnagramDiscoverer {

    @Override
    public boolean areAnagrams(String string1, String string2) {
        validateInput(string1, string2);

        String string1Normalized = normalize(string1);
        String string2Normalized = normalize(string2);

        return string1Normalized.equals(string2Normalized);
    }

    private void validateInput(String string1, String string2) {
        if (isNull(string1) || isNull(string2)) {
            throw new IllegalArgumentException();
        }
    }

    private String normalize(String string) {
        String normalizingString = string;
        normalizingString = removeWhiteSpaces(normalizingString);
        normalizingString = toLowerCase(normalizingString);
        normalizingString = sortLettersAlphabetically(normalizingString);
        return normalizingString;
    }

    private String sortLettersAlphabetically(String string) {
        return string.chars()
                .mapToObj(ch -> (char) ch)
                .sorted()
                .map(Object::toString)
                .collect(joining());
    }

    private String removeWhiteSpaces(String string) {
        return string.chars()
                .mapToObj(ch -> (char) ch)
                .filter(not(Character::isWhitespace))
                .map(Object::toString)
                .collect(joining());
    }

    private String toLowerCase(String string) {
        return string.chars()
                .mapToObj(ch -> (char) ch)
                .map(Character::toLowerCase)
                .map(Object::toString)
                .collect(joining());
    }
}
