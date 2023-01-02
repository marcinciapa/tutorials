package com.github.marcinciapa._20;

import static java.util.Objects.isNull;

class SelfInventedStringRepeater implements StringRepeater {

    @Override
    public String repeatTimes(int n, String string) {
        if (isNull(string) || n < 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            output.append(string);
        }
        return output.toString();
    }
}
