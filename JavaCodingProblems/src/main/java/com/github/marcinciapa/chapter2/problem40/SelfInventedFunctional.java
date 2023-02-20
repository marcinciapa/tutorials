package com.github.marcinciapa.chapter2.problem40;

import java.util.Objects;

class SelfInventedFunctional implements NullChecker {

    @Override
    public boolean isNull(Object object) {
        return Objects.isNull(object);
    }
}
