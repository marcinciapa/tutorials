package com.github.marcinciapa.chapter5.problem109;

import java.util.Objects;

class MutableObject {

    int value;

    MutableObject(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MutableObject(%d)".formatted(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableObject that = (MutableObject) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
