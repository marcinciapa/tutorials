package com.github.marcinciapa._21;

import static java.util.Objects.isNull;

class SuggestedStringTrimmer implements StringTrimmer {

    @Override
    public String trim(String inputString) {
        if(isNull(inputString)) {
            return null;
        }
        return inputString.strip();
    }
}
