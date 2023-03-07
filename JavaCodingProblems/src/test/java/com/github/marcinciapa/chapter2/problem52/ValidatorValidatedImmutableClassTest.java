package com.github.marcinciapa.chapter2.problem52;

class ValidatorValidatedImmutableClassTest extends ValidatedImmutableClassTest<ValidatorValidatedImmutableClass> {

    @Override
    ValidatedImmutableClassBuilder<ValidatorValidatedImmutableClass> builder() {
        return ValidatorValidatedImmutableClass.builder();
    }
}
