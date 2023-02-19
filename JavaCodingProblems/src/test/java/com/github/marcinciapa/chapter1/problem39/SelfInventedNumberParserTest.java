package com.github.marcinciapa.chapter1.problem39;

class SelfInventedNumberParserTest extends NumberParserTest<SelfInventedNumberParser> {

    @Override
    SelfInventedNumberParser createParser() {
        return new SelfInventedNumberParser();
    }
}
