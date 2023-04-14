package com.github.marcinciapa.chapter3.problem65;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

abstract class DateShifterTest<T extends DateShifter> {

    abstract T shifter(Date date);

    @Test
    void shouldAddDays() {
        // given
        Date initialDate = new Date(1681466639000L); // 2023-04-14T10:03:59 UTC
        Date expectedDate = new Date(1681639439000L); // 2023-04-16T10:03:59 UTC
        T shifter = shifter(initialDate);

        // when
        Date result = shifter.plusDays(2);

        // then
        assertEquals(expectedDate, result);
    }

    @Test
    void shouldSubtractHours() {
        // given
        Date initialDate = new Date(1681466639000L); // 2023-04-14T10:03:59 UTC
        Date expectedDate = new Date(1681459439000L); // 2023-04-14T08:03:59 UTC
        T shifter = shifter(initialDate);

        // when
        Date result = shifter.minusHours(2);

        // then
        assertEquals(expectedDate, result);
    }
}
