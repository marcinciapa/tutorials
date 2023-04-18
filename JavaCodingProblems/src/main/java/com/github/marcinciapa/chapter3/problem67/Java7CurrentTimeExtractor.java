package com.github.marcinciapa.chapter3.problem67;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static java.util.Arrays.stream;

class Java7CurrentTimeExtractor implements CurrentTimeExtractor {

    private final Clock clock;

    Java7CurrentTimeExtractor(Clock clock) {
        this.clock = clock;
    }

    @Override
    public List<String> currentTime() {
        Date now = Date.from(Instant.now(clock));
        return stream(TimeZone.getAvailableIDs())
                .map(timeZone -> toZonedString(now, timeZone))
                .toList();
    }

    private static String toZonedString(Date now, String timeZone) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return dateFormat.format(now);
    }
}
