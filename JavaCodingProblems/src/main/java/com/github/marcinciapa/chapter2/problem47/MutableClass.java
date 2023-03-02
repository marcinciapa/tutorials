package com.github.marcinciapa.chapter2.problem47;

import java.util.Objects;

class MutableClass {

    int i = 0;

    MutableClass(int i) {
        this.i = i;
    }

    int getI() {
        return i;
    }

    void setI(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableClass that = (MutableClass) o;
        return i == that.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
