package com.github.marcinciapa.chapter3.problem74;

import java.time.Clock;
import java.time.Instant;

class Java8AgeCalculatorTest extends AgeCalculatorTest<Java8AgeCalculator> {


    @Override
    Java8AgeCalculator calculator(Instant dateOfBirth, Clock clock) {
        return new Java8AgeCalculator(dateOfBirth, clock);
    }
}
