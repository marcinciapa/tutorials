package com.github.marcinciapa._24;

import static java.util.Objects.isNull;

class SelfInventedStringTransformer implements StringTransformer {

    @Override
    public String upperCaseRepeatedWithoutWhitespaces(String string) {
        if (isNull(string)) {
            throw new IllegalArgumentException();
        }
        String upperCase = string.toUpperCase();
        String upperCaseWithoutWhitespaces = upperCase.replaceAll("\\s", "");
        String upperCaseWithoutWhitespacesRepeated = upperCaseWithoutWhitespaces + upperCaseWithoutWhitespaces;
        return upperCaseWithoutWhitespacesRepeated;
    }
}
