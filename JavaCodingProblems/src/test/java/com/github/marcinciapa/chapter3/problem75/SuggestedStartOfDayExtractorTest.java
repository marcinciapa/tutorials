package com.github.marcinciapa.chapter3.problem75;

class SuggestedStartOfDayExtractorTest extends StartOfDayExtractorTest<SuggestedStartOfDayExtractor> {

    @Override
    SuggestedStartOfDayExtractor extractor() {
        return new SuggestedStartOfDayExtractor();
    }
}
