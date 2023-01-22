package com.github.marcinciapa.chapter1.problem17;

class SelfInventedSubstringCounterTest extends SubstringCounterTest<SelfInventedSubstringCounter> {

    @Override
    SelfInventedSubstringCounter createInstance() {
        return new SelfInventedSubstringCounter();
    }
}
