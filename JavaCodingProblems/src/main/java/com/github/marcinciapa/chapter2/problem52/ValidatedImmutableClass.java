package com.github.marcinciapa.chapter2.problem52;

class ValidatedImmutableClass {

    private final Integer value;

    private ValidatedImmutableClass(Builder builder) {
        this.value = builder.value;
    }

    static Builder builder() {
        return new Builder();
    }

    int value() {
        return this.value;
    }

    static class Builder {
        private Integer value;

        private Builder() {
        }

        Builder withValue(Integer value) {
            this.value = value;
            return this;
        }

        ValidatedImmutableClass build() {
            if (value == null) {
                throw new IllegalStateException("Value cannot be null");
            }
            return new ValidatedImmutableClass(this);
        }
    }
}
