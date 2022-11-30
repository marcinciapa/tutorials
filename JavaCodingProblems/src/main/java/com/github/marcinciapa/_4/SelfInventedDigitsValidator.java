package com.github.marcinciapa._4;

import java.util.regex.Pattern;

import static java.util.Objects.isNull;

class SelfInventedDigitsValidator {

    private final Pattern digitsOnlyPattern = Pattern.compile("\\d+");

    boolean containsDigitsOnly(String inputString) {
        if(isNull(inputString)) {
            return false;
        }
        return digitsOnlyPattern.matcher(inputString).matches();
    }
}
