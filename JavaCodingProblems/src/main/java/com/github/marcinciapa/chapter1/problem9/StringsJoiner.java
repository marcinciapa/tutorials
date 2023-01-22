package com.github.marcinciapa.chapter1.problem9;

import static java.util.Objects.isNull;

interface StringsJoiner {

    String joinWithDelimiter(String delimiter, String... parts);

    default void validateParts(String[] parts) {
        for (String part : parts) {
            if (isNull(part)) {
                throw new IncorrectInputDataException();
            }
        }
    }

    default void validateDelimiter(String delimiter) {
        if (isNull(delimiter)) {
            throw new IncorrectInputDataException();
        }
    }
}
