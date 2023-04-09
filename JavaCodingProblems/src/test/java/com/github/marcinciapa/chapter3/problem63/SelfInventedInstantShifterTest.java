package com.github.marcinciapa.chapter3.problem63;

class SelfInventedInstantShifterTest extends InstantShifterTest<SelfInventedInstantShifter> {

    @Override
    SelfInventedInstantShifter shifter() {
        return new SelfInventedInstantShifter();
    }
}
