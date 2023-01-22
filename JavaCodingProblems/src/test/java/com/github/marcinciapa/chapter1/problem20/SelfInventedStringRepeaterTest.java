package com.github.marcinciapa.chapter1.problem20;

class SelfInventedStringRepeaterTest extends StringRepeaterTest<SelfInventedStringRepeater> {

    @Override
    protected SelfInventedStringRepeater createInstance() {
        return new SelfInventedStringRepeater();
    }
}
