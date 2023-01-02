package com.github.marcinciapa._20;

class SelfInventedStringRepeaterTest extends StringRepeaterTest<SelfInventedStringRepeater> {

    @Override
    protected SelfInventedStringRepeater createInstance() {
        return new SelfInventedStringRepeater();
    }
}
