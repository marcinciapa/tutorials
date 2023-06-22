package com.github.marcinciapa.chapter5.problem108;

class SelfInventedAppenderTest extends ArrayAppenderTest<SelfInventedAppender> {

    @Override
    SelfInventedAppender appender(int[] initialArray) {
        return new SelfInventedAppender(initialArray);
    }
}
