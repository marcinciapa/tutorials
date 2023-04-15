package com.github.marcinciapa.chapter3.problem65;

import java.time.LocalDateTime;

class SelfInventedLocalDateTimeShifterTest extends LocalDateTimeShifterTest<SelfInventedLocalDateTimeShifter> {

    @Override
    SelfInventedLocalDateTimeShifter shifter(LocalDateTime date) {
        return new SelfInventedLocalDateTimeShifter(date);
    }
}
