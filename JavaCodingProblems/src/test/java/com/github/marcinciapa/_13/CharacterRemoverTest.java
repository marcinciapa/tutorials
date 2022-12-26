package com.github.marcinciapa._13;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface CharacterRemoverTest<T extends CharacterRemover> {

    T createInstance();

    @ParameterizedTest
    @MethodSource("testData")
    default void shouldRemoveCharacterFromString(String inputString, char character, String expectedResult) {
        // given
        T characterRemover = createInstance();

        // when
        String result = characterRemover.removeCharacter(character, inputString);

        // then
        assertEquals(expectedResult, result);
    }


    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(null, 'a', null),
                Arguments.of("", 'a', ""),
                Arguments.of("abc", 'd', "abc"),
                Arguments.of("abcabc", 'a', "bcbc"),
                Arguments.of("a\\b", '\\', "ab")
        );
    }
}
