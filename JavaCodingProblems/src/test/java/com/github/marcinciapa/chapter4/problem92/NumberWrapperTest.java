package com.github.marcinciapa.chapter4.problem92;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberWrapperTest {

    @Test
    void shouldAddNumbers() {
        // given
        var number1 = 4;
        var number2 = 8;
        var expectedResult = new WrappedNumber(12);

        // when
        var wrappedNumber1 = new WrappedNumber(number1);
        var wrappedNumber2 = new WrappedNumber(number2);

        // when
        var result = wrappedNumber1.plus(wrappedNumber2);

        // then
        assertEquals(expectedResult, result);
    }
}
