package com.github.marcinciapa.chapter4.problem80;

class IntCalculatorTest extends CalculatorTest<IntCalculator, Integer> {

    @Override
    IntCalculator calculator(int number1, int number2) {
        return new IntCalculator(number1, number2);
    }

    @Override
    Integer expectedResult(int number1, int number2) {
        return number1 * number2;
    }
}
