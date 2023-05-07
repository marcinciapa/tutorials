package com.github.marcinciapa.chapter3.problem76;

import java.time.Instant;
import java.util.Date;

class SelfInventedJava7ImplementationTest extends TimeDifferenceCalculatorTest<SelfInventedJava7Implementation> {

    @Override
    SelfInventedJava7Implementation calculator(Instant time1, Instant time2) {
        Date date1 = Date.from(time1);
        Date date2 = Date.from(time2);
        return new SelfInventedJava7Implementation(date1, date2);
    }
}
