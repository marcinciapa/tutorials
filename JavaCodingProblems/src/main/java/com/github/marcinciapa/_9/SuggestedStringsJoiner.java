package com.github.marcinciapa._9;

import java.util.StringJoiner;

class SuggestedStringsJoiner implements StringsJoiner {

    @Override
    public String joinWithDelimiter(String delimiter, String... parts) {
        validateDelimiter(delimiter);
        validateParts(parts);
        StringJoiner joiner = new StringJoiner(delimiter);
        for (String part : parts) {
            if (!part.isEmpty()) {
                joiner.add(part);
            }
        }
        return joiner.toString();
    }
}
