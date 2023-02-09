package com.github.marcinciapa.chapter1.problem37;

import java.math.BigInteger;

class SuggestedMultiplier implements Multiplier {

    @Override
    public int multiply(int number1, int number2) {
        BigInteger bigNumber1 = BigInteger.valueOf(number1);
        BigInteger bigNumber2 = BigInteger.valueOf(number2);

        BigInteger multiplyResult = bigNumber1.multiply(bigNumber2);
        return multiplyResult.intValueExact();
    }
}
