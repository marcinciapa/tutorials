package com.github.marcinciapa.chapter2.problem41;

import static java.util.Objects.requireNonNull;

class SuggestedNullChecker implements NullChecker {

    @Override
    public void checkNotNull(Object object) {
        requireNonNull(object, "Argument cannot be null");
    }
}
