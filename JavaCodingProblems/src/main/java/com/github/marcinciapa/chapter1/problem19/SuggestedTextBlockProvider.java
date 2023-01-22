package com.github.marcinciapa.chapter1.problem19;

import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

class SuggestedTextBlockProvider implements TextBlockProvider {

    @Override
    public String provideTextBlock() {
        return Stream.of("This", "is", "a", "multiline", "string")
                .collect(joining(lineSeparator()));
    }
}
