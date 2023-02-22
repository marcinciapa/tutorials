package com.github.marcinciapa.chapter2.problem43;

import static java.util.Objects.requireNonNullElse;

class SelfInventedNullChecker implements NullChecker {

    @Override
    public String nonNullOrDefault(String string) {
        return requireNonNullElse(string, "Default string");
    }
}
