package com.github.marcinciapa.chapter3.problem65;

import java.util.Date;

class SuggestedDateShifterTest extends DateShifterTest<SuggestedDateShifter> {

    @Override
    SuggestedDateShifter shifter(Date date) {
        return new SuggestedDateShifter(date);
    }
}
