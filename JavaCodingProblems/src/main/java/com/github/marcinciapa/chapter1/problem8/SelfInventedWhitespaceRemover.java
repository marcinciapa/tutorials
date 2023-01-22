package com.github.marcinciapa.chapter1.problem8;

import static java.util.Objects.isNull;

class SelfInventedWhitespaceRemover implements WhitespaceRemover {

    @Override
    public String removeWhitespace(String inputString) {
        if (isNull(inputString)) {
            return null;
        }
        return inputString.replaceAll("\\s", "");
    }
}
