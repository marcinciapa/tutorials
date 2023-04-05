package com.github.marcinciapa.chapter3.problem62;

class SelfInventedInstantParserTest extends InstantParserTest<SelfInventedInstantParser> {

    @Override
    SelfInventedInstantParser instantParser() {
        return new SelfInventedInstantParser();
    }
}
