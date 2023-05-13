package com.github.marcinciapa.chapter4.problem80;

class LongCalculatorTest extends CalculatorTest<LongCalculator, Long> {

    @Override
    LongCalculator calculator(int number1, int number2) {
        return new LongCalculator(number1, number2);
    }

    @Override
    Long expectedResult(int number1, int number2) {
        return (long) number1 * (long) number2;
    }
}
