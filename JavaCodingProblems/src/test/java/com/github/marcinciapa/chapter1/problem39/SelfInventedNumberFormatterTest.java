package com.github.marcinciapa.chapter1.problem39;

class SelfInventedNumberFormatterTest extends NumberFormatterTest<SelfInventedNumberFormatter> {

    @Override
    SelfInventedNumberFormatter createFormatter() {
        return new SelfInventedNumberFormatter();
    }
}
