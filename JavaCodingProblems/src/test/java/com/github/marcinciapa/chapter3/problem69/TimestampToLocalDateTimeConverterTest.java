package com.github.marcinciapa.chapter3.problem69;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

class TimestampToLocalDateTimeConverterTest
        extends TimestampToTimeConverterTest<TimestampToLocalDateTimeConverter, LocalDateTime> {

    @Override
    TimestampToLocalDateTimeConverter converter() {
        return new TimestampToLocalDateTimeConverter();
    }

    @Override
    LocalDateTime expected(Instant instant) {
        Instant instant1 = Instant.ofEpochMilli(instant.toEpochMilli());
        return LocalDateTime.ofInstant(instant1, ZoneId.of("UTC"));
    }
}
