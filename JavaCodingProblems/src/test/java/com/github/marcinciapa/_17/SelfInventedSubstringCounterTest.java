package com.github.marcinciapa._17;

class SelfInventedSubstringCounterTest extends SubstringCounterTest<SelfInventedSubstringCounter> {

    @Override
    SelfInventedSubstringCounter createInstance() {
        return new SelfInventedSubstringCounter();
    }
}
