package com.github.marcinciapa.chapter3.problem67;

import java.time.Clock;

class Java8CurrentTimeExtractorTest extends CurrentTimeExtractorTest<Java8CurrentTimeExtractor> {

    @Override
    Java8CurrentTimeExtractor extractor(Clock clock) {
        return new Java8CurrentTimeExtractor(clock);
    }
}
