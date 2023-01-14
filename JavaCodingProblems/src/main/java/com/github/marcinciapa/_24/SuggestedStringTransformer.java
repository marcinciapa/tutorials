package com.github.marcinciapa._24;

import java.util.Optional;

class SuggestedStringTransformer implements StringTransformer {

    @Override
    public String upperCaseRepeatedWithoutWhitespaces(String string) {

        return Optional.ofNullable(string)
                .map(str -> str
                        .transform(String::toUpperCase)
                        .transform(s -> s.replaceAll("\\s", ""))
                        .transform(s -> s.repeat(2)))
                .orElseThrow(IllegalArgumentException::new);

    }
}
