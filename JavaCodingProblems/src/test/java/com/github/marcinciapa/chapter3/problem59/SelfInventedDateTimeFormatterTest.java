package com.github.marcinciapa.chapter3.problem59;

class SelfInventedDateTimeFormatterTest extends DateTimeFormatterTest<SelfInventedDateTimeFormatter> {

    @Override
    SelfInventedDateTimeFormatter createInstance() {
        return new SelfInventedDateTimeFormatter();
    }
}
