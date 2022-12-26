package com.github.marcinciapa._13;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;

class SelfInventedCharacterRemover implements CharacterRemover {

    @Override
    public String removeCharacter(char character, String inputString) {
        if(isNull(inputString)) {
            return null;
        }
        return inputString.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> isNotEqual(character, c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static boolean isNotEqual(char character, int c) {
        return c != character;
    }
}
