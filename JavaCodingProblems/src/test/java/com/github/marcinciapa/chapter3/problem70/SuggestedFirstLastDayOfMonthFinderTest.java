package com.github.marcinciapa.chapter3.problem70;

import java.time.LocalDateTime;

class SuggestedFirstLastDayOfMonthFinderTest extends FirstLastDayOfMonthFinderTest<SuggestedFirstLastDayOfMonthFinder> {

    @Override
    SuggestedFirstLastDayOfMonthFinder finder(LocalDateTime date) {
        return new SuggestedFirstLastDayOfMonthFinder(date);
    }
}
