package com.github.marcinciapa.chapter1.problem33;

import java.math.BigInteger;

import static java.util.Objects.isNull;

class SuggestedBigIntPrimitiveExtractor implements BigIntPrimitiveExtractor {

    @Override
    public int toPrimitive(BigInteger number) {
        if(isNull(number)) {
            throw new IllegalArgumentException();
        }
        return number.intValueExact();
    }
}
