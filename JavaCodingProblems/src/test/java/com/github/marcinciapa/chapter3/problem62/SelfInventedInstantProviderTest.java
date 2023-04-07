package com.github.marcinciapa.chapter3.problem62;

import java.time.Clock;

class SelfInventedInstantProviderTest extends InstantProviderTest<SelfInventedInstantProvider> {

    @Override
    SelfInventedInstantProvider provider(Clock clock) {
        return new SelfInventedInstantProvider(clock);
    }
}
