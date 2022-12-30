package com.github.marcinciapa._17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;
import static java.util.regex.Pattern.quote;

class SuggestedSubstringCounter implements SubstringCounter {

    @Override
    public int countSubstringOccurrences(String inputString, String substring) {
        if (isNull(inputString) || isNull(substring) || substring.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Pattern pattern = Pattern.compile(quote(substring));
        Matcher matcher = pattern.matcher(inputString);

        int position = 0;
        int substringCount = 0;

        while (matcher.find(position)) {
            position = matcher.start() + 1;
            substringCount++;
        }

        return substringCount;
    }
}
