package com.github.marcinciapa.chapter1.problem23;

import static java.util.Objects.isNull;

class SuggestedIndentationApplier implements IndentationApplier {

    @Override
    public String indented(String string) {
        if(isNull(string)) {
            throw new IllegalArgumentException();
        }
        return string.indent(2);
    }
}
