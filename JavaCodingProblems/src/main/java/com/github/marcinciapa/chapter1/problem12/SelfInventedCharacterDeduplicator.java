package com.github.marcinciapa.chapter1.problem12;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;

class SelfInventedCharacterDeduplicator implements CharacterDeduplicator {

    @Override
    public String removeDuplicateChars(String inputString) {
        if(isNull(inputString)) {
            return null;
        }
        return inputString.chars()
                .mapToObj(character -> (char) character)
                .map(String::valueOf)
                .distinct()
                .collect(Collectors.joining());
    }
}
