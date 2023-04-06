package com.github.marcinciapa.chapter3.problem62;

import java.time.Instant;

class SelfInventedInstantTimeAdderTest extends InstantTimeAdderTest<SelfInventedInstantTimeAdder> {

    @Override
    SelfInventedInstantTimeAdder timeAdder(Instant initialInstant) {
        return new SelfInventedInstantTimeAdder(initialInstant);
    }
}
