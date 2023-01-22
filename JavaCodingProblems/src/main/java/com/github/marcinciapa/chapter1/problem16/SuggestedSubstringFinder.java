package com.github.marcinciapa.chapter1.problem16;

import java.util.regex.Pattern;

import static java.util.Objects.isNull;

class SuggestedSubstringFinder implements SubstringFinder {

    @Override
    public boolean contains(String substring, String inputString) {
        if (isNull(substring) || isNull(inputString)) {
            return false;
        }

        String substringContainedRegex = ".*%s.*".formatted(Pattern.quote(substring));
        return inputString.matches(substringContainedRegex);
    }
}
