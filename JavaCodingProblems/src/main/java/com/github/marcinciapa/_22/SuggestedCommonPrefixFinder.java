package com.github.marcinciapa._22;

import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;
import static java.util.Objects.isNull;

class SuggestedCommonPrefixFinder implements CommonPrefixFinder {

    @Override
    public String findCommonPrefix(List<String> strings) {
        if (isNull(strings) || anyNull(strings)) {
            throw new IllegalArgumentException();
        }

        if (strings.isEmpty()) {
            return "";
        }

        if (strings.size() == 1) {
            return strings.get(0);
        }

        return commonPrefixOfMultipleStrings(strings);
    }

    private String commonPrefixOfMultipleStrings(List<String> strings) {
        String shortestString = shortestOf(strings);

        int candidateStartPosition = 0;
        int candidateEndPosition = shortestString.length();

        StringBuilder commonPrefix = new StringBuilder();

        while (candidateStartPosition < candidateEndPosition) {
            int candidateMiddlePosition = (candidateEndPosition + candidateStartPosition) / 2 + 1;
            String candidateSubstring = shortestString.substring(candidateStartPosition, candidateMiddlePosition);
            String candidatePrefix = commonPrefix + candidateSubstring;
            if (isPrefixOfAll(strings, candidatePrefix)) {
                commonPrefix.append(candidateSubstring);
                candidateStartPosition = candidateMiddlePosition;
                candidateEndPosition = shortestString.length();
            } else {
                candidateEndPosition = candidateMiddlePosition - 1;
            }
        }

        return commonPrefix.toString();
    }

    private boolean anyNull(List<String> strings) {
        return strings.stream()
                .anyMatch(Objects::isNull);
    }

    private String shortestOf(List<String> strings) {
        return strings.stream()
                .min(comparing(String::length))
                .orElse("");
    }

    private boolean isPrefixOfAll(List<String> strings, String prefixCandidate) {
        return strings.stream()
                .allMatch(string -> string.startsWith(prefixCandidate));
    }
}
