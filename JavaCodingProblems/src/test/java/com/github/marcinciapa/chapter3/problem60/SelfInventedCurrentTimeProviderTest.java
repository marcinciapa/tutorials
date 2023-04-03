package com.github.marcinciapa.chapter3.problem60;

import java.time.Clock;

class SelfInventedCurrentTimeProviderTest extends CurrentTimeProviderTest<SelfInventedCurrentTimeProvider> {

    @Override
    SelfInventedCurrentTimeProvider createInstance(Clock clock) {
        return new SelfInventedCurrentTimeProvider(clock);
    }
}
