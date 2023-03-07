package com.github.marcinciapa.chapter2.problem52;

class SelfValidatedImmutableClass implements ValidatedImmutableClass {

    private final Integer value;

    private SelfValidatedImmutableClass(Integer value) {
        this.value = value;
    }

    static ValidatedImmutableClassBuilder<SelfValidatedImmutableClass> builder() {
        return new ValidatedImmutableClassBuilder<>() {
            @Override
            SelfValidatedImmutableClass build() {
                if(super.value == null) {
                    throw new IllegalStateException();
                }
                return new SelfValidatedImmutableClass(super.value);
            }
        };
    }

    @Override
    public int value() {
        return this.value;
    }
}
