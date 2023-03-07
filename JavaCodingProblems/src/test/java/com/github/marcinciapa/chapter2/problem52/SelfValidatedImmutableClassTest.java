package com.github.marcinciapa.chapter2.problem52;

class SelfValidatedImmutableClassTest extends ValidatedImmutableClassTest<SelfValidatedImmutableClass> {

    @Override
    ValidatedImmutableClassBuilder<SelfValidatedImmutableClass> builder() {
        return SelfValidatedImmutableClass.builder();
    }
}
