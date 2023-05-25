package com.github.marcinciapa.chapter4.problem92;

record WrappedNumber(int number) {

    WrappedNumber plus(WrappedNumber otherNumber) {
        return new WrappedNumber(number + otherNumber.number());
    }
}
