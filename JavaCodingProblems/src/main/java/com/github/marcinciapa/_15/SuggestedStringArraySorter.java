package com.github.marcinciapa._15;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Objects.isNull;

class SuggestedStringArraySorter implements StringArraySorter {

    @Override
    public String[] sortByLength(String[] inputArray) {
        if (isNull(inputArray)) {
            return null;
        }

        Stream<String> streamOfNulls = Arrays.stream(inputArray)
                .filter(Objects::isNull);

        Stream<String> streamOfSortedStrings = Arrays.stream(inputArray)
                .filter(Objects::nonNull)
                .sorted(comparing(String::length)
                        .thenComparing(String::compareTo)
                );

        return Stream.concat(streamOfNulls, streamOfSortedStrings).toArray(String[]::new);
    }
}
