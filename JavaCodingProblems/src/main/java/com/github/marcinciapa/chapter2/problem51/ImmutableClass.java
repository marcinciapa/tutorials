package com.github.marcinciapa.chapter2.problem51;

final class ImmutableClass {

    private final int x;
    private final int y;
    private final int mandatory;

    private ImmutableClass(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.mandatory = builder.mandatory;
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

    int mandatory() {
        return mandatory;
    }

    static Builder builder(int mandatory) {
        return new Builder(mandatory);
    }

    static class Builder {

        private int x;
        private int y;
        private int mandatory;

        private Builder(int mandatory) {
            this.mandatory = mandatory;
        }

        Builder withX(int x) {
            this.x = x;
            return this;
        }

        Builder withY(int y) {
            this.y = y;
            return this;
        }

        ImmutableClass build() {
            return new ImmutableClass(this);
        }
    }
}
