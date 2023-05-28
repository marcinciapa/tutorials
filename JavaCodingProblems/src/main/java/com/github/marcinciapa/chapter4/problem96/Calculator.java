package com.github.marcinciapa.chapter4.problem96;

class Calculator {

    private final int number1;
    private final int number2;

    Calculator(Integer number1, Integer number2) throws InitException {
        if(number1 == null || number2 == null) {
            throw new InitException("Numbers cannot be null");
        }
        this.number1 = number1;
        this.number2 = number2;
    }

    int sum() {
        return number1 + number2;
    }
}
