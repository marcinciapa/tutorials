package com.github.marcinciapa.chapter2.problem50;

import java.util.Objects;

class MutableTestObject implements Copyable {

    int i;

    MutableTestObject(int i) {
        this.i = i;
    }

    int getI() {
        return i;
    }

    @Override
    public Copyable copy() {
        return new MutableTestObject(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableTestObject that = (MutableTestObject) o;
        return i == that.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
