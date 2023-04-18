package com.github.marcinciapa.chapter3.problem67;

import java.time.Clock;

class Java7CurrentTimeExtractorTest extends CurrentTimeExtractorTest<Java7CurrentTimeExtractor> {

    @Override
    Java7CurrentTimeExtractor extractor(Clock clock) {
        return new Java7CurrentTimeExtractor(clock);
    }
}
