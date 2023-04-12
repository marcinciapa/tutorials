package com.github.marcinciapa.chapter3.problem64;

class SelfInventedTimeUnitExtractorTest extends TimeUnitExtractorTest<SelfInventedTimeUnitExtractor> {

    @Override
    SelfInventedTimeUnitExtractor extractor() {
        return new SelfInventedTimeUnitExtractor();
    }
}
