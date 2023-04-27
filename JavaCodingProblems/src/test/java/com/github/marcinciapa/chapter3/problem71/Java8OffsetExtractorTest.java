package com.github.marcinciapa.chapter3.problem71;

class Java8OffsetExtractorTest extends OffsetExtractorTest<Java8OffsetExtractor> {

    @Override
    Java8OffsetExtractor offsetExtractor() {
        return new Java8OffsetExtractor();
    }
}
