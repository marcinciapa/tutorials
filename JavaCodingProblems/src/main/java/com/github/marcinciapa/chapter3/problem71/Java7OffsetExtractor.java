package com.github.marcinciapa.chapter3.problem71;

import java.util.TimeZone;

import static java.util.Arrays.stream;

class Java7OffsetExtractor implements OffsetExtractor {

    @Override
    public int getOffset(String timeZone) {
        if (timeZone == null) {
            throw new IllegalArgumentException();
        }
        if (incorrectTimeZone(timeZone)) {
            throw new IllegalArgumentException();
        }

        TimeZone zone = TimeZone.getTimeZone(timeZone);
        return zone.getRawOffset();
    }

    private boolean incorrectTimeZone(String timeZone) {
        return stream(TimeZone.getAvailableIDs())
                .noneMatch(id -> id.equals(timeZone));
    }
}
