package com.github.marcinciapa.chapter4.problem82;

class SelfInventedCalculatorTest extends CalculatorTest<SelfInventedCalculator> {

    @Override
    SelfInventedCalculator calculator(int number1, int number2) {
        return new SelfInventedCalculator(number1, number2);
    }
}
