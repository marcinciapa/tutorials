package com.github.marcinciapa.chapter3.problem69;

import java.time.Instant;
import java.util.Date;

class TimestampToDateConverterTest extends TimestampToTimeConverterTest<TimestampToDateConverter, Date> {

    @Override
    TimestampToDateConverter converter() {
        return new TimestampToDateConverter();
    }

    @Override
    Date expected(Instant instant) {
        return Date.from(instant);
    }
}
