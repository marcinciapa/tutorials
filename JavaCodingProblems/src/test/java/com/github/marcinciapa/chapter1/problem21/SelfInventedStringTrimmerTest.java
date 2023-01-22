package com.github.marcinciapa.chapter1.problem21;

class SelfInventedStringTrimmerTest extends StringTrimmerTest<SelfInventedStringTrimmer> {

    @Override
    protected SelfInventedStringTrimmer createInstance() {
        return new SelfInventedStringTrimmer();
    }
}
