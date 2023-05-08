package com.github.marcinciapa.chapter3.problem76;

import java.time.Instant;

class SelfInventedJava8ImplementationTest extends TimeDifferenceCalculatorTest<SelfInventedJava8Implementation> {

    @Override
    SelfInventedJava8Implementation calculator(Instant time1, Instant time2) {
        return new SelfInventedJava8Implementation(time1, time2);
    }
}
