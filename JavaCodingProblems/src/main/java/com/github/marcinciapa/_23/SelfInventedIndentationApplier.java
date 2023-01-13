package com.github.marcinciapa._23;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.joining;

class SelfInventedIndentationApplier implements IndentationApplier {
    @Override
    public String indented(String string) {
        if (isNull(string)) {
            throw new IllegalArgumentException();
        }

        return string.lines()
                .map(line -> format("  %s\n", line))
                .collect(joining());
    }
}
