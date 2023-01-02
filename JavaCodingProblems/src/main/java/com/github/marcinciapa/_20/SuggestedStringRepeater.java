package com.github.marcinciapa._20;

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
