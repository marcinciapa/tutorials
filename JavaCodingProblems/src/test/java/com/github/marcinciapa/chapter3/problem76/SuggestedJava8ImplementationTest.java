package com.github.marcinciapa.chapter3.problem76;

import java.time.Instant;

class SuggestedJava8ImplementationTest extends TimeDifferenceCalculatorTest<SuggestedJava8Implementation> {

    @Override
    SuggestedJava8Implementation calculator(Instant time1, Instant time2) {
        return new SuggestedJava8Implementation(time1, time2);
    }
}
