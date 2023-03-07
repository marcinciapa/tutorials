package com.github.marcinciapa.chapter2.problem52;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

abstract class ValidatedImmutableClassBuilder<T extends ValidatedImmutableClass> {

    @NotNull
    @Min(0)
    protected Integer value;

    protected ValidatedImmutableClassBuilder() {
    }

    ValidatedImmutableClassBuilder<T> withValue(Integer value) {
        this.value = value;
        return this;
    }

    abstract T build();
}
