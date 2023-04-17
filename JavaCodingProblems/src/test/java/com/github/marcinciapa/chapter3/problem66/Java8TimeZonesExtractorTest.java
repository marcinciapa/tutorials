package com.github.marcinciapa.chapter3.problem66;

class Java8TimeZonesExtractorTest extends TimeZonesExtractorTest<Java8TimeZonesExtractor> {

    @Override
    Java8TimeZonesExtractor extractor() {
        return new Java8TimeZonesExtractor();
    }
}
