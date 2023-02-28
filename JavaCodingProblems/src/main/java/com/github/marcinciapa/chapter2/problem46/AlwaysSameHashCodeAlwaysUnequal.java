package com.github.marcinciapa.chapter2.problem46;

class AlwaysSameHashCodeAlwaysUnequal {

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
