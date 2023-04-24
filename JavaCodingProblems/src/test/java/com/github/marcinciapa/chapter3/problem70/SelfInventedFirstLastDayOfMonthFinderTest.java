package com.github.marcinciapa.chapter3.problem70;

import java.time.LocalDateTime;

class SelfInventedFirstLastDayOfMonthFinderTest extends FirstLastDayOfMonthFinderTest<SelfInventedFirstLastDayOfMonthFinder> {

    @Override
    SelfInventedFirstLastDayOfMonthFinder finder(LocalDateTime date) {
        return new SelfInventedFirstLastDayOfMonthFinder(date);
    }
}
