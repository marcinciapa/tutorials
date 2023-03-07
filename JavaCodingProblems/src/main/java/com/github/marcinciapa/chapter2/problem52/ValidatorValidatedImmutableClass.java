package com.github.marcinciapa.chapter2.problem52;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;

class ValidatorValidatedImmutableClass implements ValidatedImmutableClass {

    private final Integer value;

    public ValidatorValidatedImmutableClass(Integer value) {
        this.value = value;
    }

    @Override
    public int value() {
        return value;
    }

    static ValidatedImmutableClassBuilder<ValidatorValidatedImmutableClass> builder() {
        return new ValidatedImmutableClassBuilder<>() {
            @Override
            ValidatorValidatedImmutableClass build() {
                Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
                Set<ConstraintViolation<ValidatedImmutableClassBuilder<ValidatorValidatedImmutableClass>>> errors =
                        validator.validate(this);
                if (!errors.isEmpty()) {
                    throw new IllegalStateException();
                }
                return new ValidatorValidatedImmutableClass(super.value);
            }
        };
    }
}
