package com.github.marcinciapa.chapter3.problem65;

import java.util.Date;

class SelfInventedDateShifterTest extends DateShifterTest<SelfInventedDateShifter> {

    @Override
    SelfInventedDateShifter shifter(Date date) {
        return new SelfInventedDateShifter(date);
    }
}
