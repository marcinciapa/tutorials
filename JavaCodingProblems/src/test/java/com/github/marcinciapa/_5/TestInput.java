package com.github.marcinciapa._5;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

class TestInput {

    private static final List<InputWithCounts> INPUT_STRINGS_WITH_COUNTS = List.of(
            new InputWithCounts(null, 0, 0),
            new InputWithCounts("", 0, 0),
            new InputWithCounts("123", 0, 0),
            new InputWithCounts("a", 1, 0),
            new InputWithCounts("b", 0, 1),
            new InputWithCounts("abcdefghijklmnopqrstuvwxyz", 6, 20),
            new InputWithCounts("ab12ab", 2, 2),
            new InputWithCounts("AB1", 1, 1)
    );

    static Stream<Arguments> vowelsCountInput() {
        return INPUT_STRINGS_WITH_COUNTS.stream()
                .map(stringWithCounts -> Arguments.of(
                        stringWithCounts.inputString(), stringWithCounts.expectedVowelsCount()
                ));
    }

    static Stream<Arguments> consonantsCountInput() {
        return INPUT_STRINGS_WITH_COUNTS.stream()
                .map(stringWithCounts -> Arguments.of(
                   stringWithCounts.inputString(), stringWithCounts.expectedConsonantsCount()
                ));
    }

    private record InputWithCounts(
            String inputString,
            int expectedVowelsCount,
            int expectedConsonantsCount
    ) {}
}
