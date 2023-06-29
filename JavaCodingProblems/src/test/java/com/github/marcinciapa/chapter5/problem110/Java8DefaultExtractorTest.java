package com.github.marcinciapa.chapter5.problem110;

import java.util.Map;

class Java8DefaultExtractorTest extends DefaultExtractorTest<Java8DefaultExtractor> {

    @Override
    Java8DefaultExtractor extractor(Map<String, Integer> map) {
        return new Java8DefaultExtractor(map);
    }
}
