package com.github.marcinciapa._21;

class SelfInventedStringTrimmerTest extends StringTrimmerTest<SelfInventedStringTrimmer> {

    @Override
    protected SelfInventedStringTrimmer createInstance() {
        return new SelfInventedStringTrimmer();
    }
}
