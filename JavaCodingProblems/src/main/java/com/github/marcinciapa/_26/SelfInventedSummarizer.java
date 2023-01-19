package com.github.marcinciapa._26;

import java.math.BigInteger;

class SelfInventedSummarizer implements Summarizer {

    @Override
    public int sum(int number1, int number2) {

        int result = number1 + number2;

        if (isSumInvalid(result, number1, number2)) {
            throw new ArithmeticException("Overflow");
        }

        return result;
    }

    private boolean isSumInvalid(int result, int number1, int number2) {
        BigInteger bigNumber1 = BigInteger.valueOf(number1);
        BigInteger bigNumber2 = BigInteger.valueOf(number2);

        BigInteger bitExpectedResult = bigNumber1.add(bigNumber2);
        BigInteger bigResult = BigInteger.valueOf(result);

        return !bigResult.equals(bitExpectedResult);
    }
}
