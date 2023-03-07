package com.github.marcinciapa.chapter2.problem52;

abstract class ValidatedImmutableClassBuilder<T extends ValidatedImmutableClass> {

    protected Integer value;

    protected ValidatedImmutableClassBuilder() {
    }

    ValidatedImmutableClassBuilder<T> withValue(Integer value) {
        this.value = value;
        return this;
    }

    abstract SelfValidatedImmutableClass build();
}
