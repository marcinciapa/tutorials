package com.github.marcinciapa.chapter1.problem20;

import static java.util.Objects.isNull;

class SuggestedStringRepeater implements StringRepeater {

    @Override
    public String repeatTimes(int n, String string) {
        if(isNull(string) || n<0) {
            throw new IllegalArgumentException();
        }

        return string.repeat(n);
    }
}
