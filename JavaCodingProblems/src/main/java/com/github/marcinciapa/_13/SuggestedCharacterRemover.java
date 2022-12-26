package com.github.marcinciapa._13;

import java.util.regex.Pattern;

import static java.util.Objects.isNull;

class SuggestedCharacterRemover implements CharacterRemover {

    @Override
    public String removeCharacter(char character, String inputString) {
        if(isNull(inputString)) {
            return null;
        }
        return inputString.replaceAll(Pattern.quote(Character.toString(character)), "");
    }
}
