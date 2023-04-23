package com.github.marcinciapa.chapter3.problem69;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

class TimestampToLocalDateTimeConverter implements TimestampToTimeConverter<LocalDateTime> {

    @Override
    public LocalDateTime convert(long timestamp) {
        long epochSeconds = timestamp / 1000;
        int epochMillis = (int) (timestamp % 1000);
        return LocalDateTime.ofEpochSecond(epochSeconds, epochMillis * 1000000, ZoneOffset.UTC);
    }
}
