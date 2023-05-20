package com.github.marcinciapa.chapter4.problem87;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class TrapezoidTest<T extends Trapezoid> {

    abstract T calculator(int a, int b, int h);

    @Test
    void shouldCalculateArea() {
        // given
        var a = 7;
        var b = 3;
        var h = 2;
        var expectedArea = 10;

        // when
        var calculatedArea = calculator(a, b, h).area();

        // then
        assertEquals(expectedArea, calculatedArea);
    }
}
