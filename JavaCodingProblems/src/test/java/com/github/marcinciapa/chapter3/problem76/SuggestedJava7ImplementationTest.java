package com.github.marcinciapa.chapter3.problem76;

import java.sql.Date;
import java.time.Instant;

class SuggestedJava7ImplementationTest extends TimeDifferenceCalculatorTest<SuggestedJava7Implementation> {

    @Override
    SuggestedJava7Implementation calculator(Instant time1, Instant time2) {
        return new SuggestedJava7Implementation(Date.from(time1), Date.from(time2));
    }
}
