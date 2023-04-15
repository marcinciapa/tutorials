package com.github.marcinciapa.chapter3.problem65;

import java.time.Instant;

class SelfInventedInstantShifterTest extends InstantShifterTest<SelfInventedInstantShifter> {

    @Override
    SelfInventedInstantShifter shifter(Instant initialInstant) {
        return new SelfInventedInstantShifter(initialInstant);
    }
}
