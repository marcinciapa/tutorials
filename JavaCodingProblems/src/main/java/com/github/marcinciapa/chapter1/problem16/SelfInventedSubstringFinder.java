package com.github.marcinciapa.chapter1.problem16;

import static java.util.Objects.isNull;

class SelfInventedSubstringFinder implements SubstringFinder {

    @Override
    public boolean contains(String substring, String inputString) {
        if (isNull(substring) || isNull(inputString)) {
            return false;
        }

        return inputString.contains(substring);
    }
}
