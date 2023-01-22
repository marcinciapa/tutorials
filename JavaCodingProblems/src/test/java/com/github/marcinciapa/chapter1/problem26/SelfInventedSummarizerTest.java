package com.github.marcinciapa.chapter1.problem26;

class SelfInventedSummarizerTest extends SummarizerTest<SelfInventedSummarizer> {

    @Override
    SelfInventedSummarizer createInstance() {
        return new SelfInventedSummarizer();
    }
}
