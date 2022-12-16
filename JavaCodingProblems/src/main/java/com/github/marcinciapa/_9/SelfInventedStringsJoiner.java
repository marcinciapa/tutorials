package com.github.marcinciapa._9;

import java.util.Arrays;
import java.util.stream.Collectors;

class SelfInventedStringsJoiner implements StringsJoiner {

    @Override
    public String joinWithDelimiter(String delimiter, String... parts) {
        validateDelimiter(delimiter);
        validateParts(parts);
        return Arrays.stream(parts)
                .filter(part -> !part.isEmpty())
                .collect(Collectors.joining(delimiter));
    }
}
