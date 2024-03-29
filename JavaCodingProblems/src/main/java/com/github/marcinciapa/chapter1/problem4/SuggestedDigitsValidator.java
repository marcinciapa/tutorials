package com.github.marcinciapa.chapter1.problem4;

import static java.util.Objects.isNull;

class SuggestedDigitsValidator {

    boolean containsDigitsOnly(String inputString) {
        if(isNull(inputString) || inputString.isEmpty()) {
            return false;
        }

        for(char character : inputString.toCharArray()) {
            if(!Character.isDigit(character)) {
                return false;
            }
        }

        return true;
    }
}
