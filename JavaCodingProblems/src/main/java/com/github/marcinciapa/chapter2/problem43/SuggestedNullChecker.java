package com.github.marcinciapa.chapter2.problem43;

import static java.util.Objects.requireNonNullElseGet;

class SuggestedNullChecker implements NullChecker {

    @Override
    public String nonNullOrDefault(String string) {
        return requireNonNullElseGet(string, () -> "Default string");
    }
}
