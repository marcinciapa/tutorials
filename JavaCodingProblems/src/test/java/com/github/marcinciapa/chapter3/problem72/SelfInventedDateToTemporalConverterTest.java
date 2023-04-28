package com.github.marcinciapa.chapter3.problem72;

import java.util.Date;

class SelfInventedDateToTemporalConverterTest extends DateToTemporalConverterTest<SelfInventedDateToTemporalConverter> {

    @Override
    SelfInventedDateToTemporalConverter converter(Date date) {
        return new SelfInventedDateToTemporalConverter(date);
    }
}
