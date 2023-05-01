package com.github.marcinciapa.chapter3.problem74;

import java.time.Clock;
import java.time.Instant;

class Java7AgeCalculatorTest extends AgeCalculatorTest<Java7AgeCalculator> {

    @Override
    Java7AgeCalculator calculator(Instant dateOfBirth, Clock clock) {
        return new Java7AgeCalculator(dateOfBirth, clock);
    }
}
