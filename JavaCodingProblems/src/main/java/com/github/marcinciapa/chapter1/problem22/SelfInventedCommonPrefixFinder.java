package com.github.marcinciapa.chapter1.problem22;

import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;
import static java.util.Objects.isNull;

class SelfInventedCommonPrefixFinder implements CommonPrefixFinder {

    @Override
    public String findCommonPrefix(List<String> strings) {
        if (isNull(strings) || anyNull(strings)) {
            throw new IllegalArgumentException();
        }

        StringBuilder commonPrefix = new StringBuilder();
        String shortestString = shortestOf(strings);

        for (int i = 0; i < shortestString.length(); ++i) {
            if (sameCharInAllStringsOnPosition(i, strings)) {
                char character = shortestString.charAt(i);
                commonPrefix.append(character);
            } else {
                return commonPrefix.toString();
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

    private boolean sameCharInAllStringsOnPosition(int position, List<String> strings) {
        long distinctCharsOnPosition = strings.stream()
                .map(string -> string.charAt(position))
                .distinct()
                .count();
        return distinctCharsOnPosition == 1;
    }
}
