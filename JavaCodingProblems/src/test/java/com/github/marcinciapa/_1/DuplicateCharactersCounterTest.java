package com.github.marcinciapa._1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateCharactersCounterTest {

    private final DuplicateCharactersCounter duplicateCharactersCounter = new DuplicateCharactersCounter();

    @ParameterizedTest
    @MethodSource("inputValues")
    void selfWrittenSolutionShouldCountDuplicateCharacters(String inputString, Map<String, Long> counts) {
        System.out.printf("Running test for %s%n", inputString);
        Map<String, Long> duplicatesCharactersCount = duplicateCharactersCounter.selfWrittenSolution(inputString);
        assertEquals(counts, duplicatesCharactersCount);

    }

    @ParameterizedTest
    @MethodSource("inputValues")
    void suggestedSolutionShouldCountDuplicateCharacters(String inputString, Map<Character, Long> counts) {
        System.out.printf("Running test for %s%n", inputString);
        Map<String, Long> duplicatesCharactersCount = duplicateCharactersCounter.suggestedSolution(inputString);
        assertEquals(counts, duplicatesCharactersCount);
    }

    private static Stream<Arguments> inputValues() {
        return Stream.of(
                Arguments.of(null, emptyMap()),
                Arguments.of("", emptyMap()),
                Arguments.of("abcd", emptyMap()),
                Arguments.of("aabbccdc", Map.of(
                                "a", 2L,
                                "b", 2L,
                                "c", 3L
                        )
                ),
                Arguments.of("%s%s".formatted(
                                String.valueOf(Character.toChars(0x0001F495)),
                                String.valueOf(Character.toChars(0x0001F495))
                        ), Map.of("%s".formatted(String.valueOf(Character.toChars(0x0001F495))), 2L)
                )
        );
    }
}
