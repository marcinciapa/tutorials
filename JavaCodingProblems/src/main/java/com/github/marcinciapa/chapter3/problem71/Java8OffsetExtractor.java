package com.github.marcinciapa.chapter3.problem71;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

class Java8OffsetExtractor implements OffsetExtractor {

    @Override
    public int getOffset(String timeZone) {
        if (timeZone == null) {
            throw new IllegalArgumentException();
        }
        if (!ZoneId.getAvailableZoneIds().contains(timeZone)) {
            throw new IllegalArgumentException();
        }
        ZoneId timeZoneId = ZoneId.of(timeZone);
        ZoneOffset offset = timeZoneId.getRules().getOffset(LocalDateTime.of(2012, 12, 12, 12, 12));
        return offset.getTotalSeconds() * 1000/*millis*/;
    }
}
