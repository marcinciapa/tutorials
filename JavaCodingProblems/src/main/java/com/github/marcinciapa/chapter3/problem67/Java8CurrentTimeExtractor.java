package com.github.marcinciapa.chapter3.problem67;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

class Java8CurrentTimeExtractor implements CurrentTimeExtractor {

    private final Clock clock;
    private final DateTimeFormatter formatter;

    public Java8CurrentTimeExtractor(Clock clock) {
        this.clock = clock;
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss z");
    }

    @Override
    public List<String> currentTime() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        return zoneIds.stream()
                .map(this::currentTimeInZone)
                .toList();
    }

    String currentTimeInZone(String timeZone) {
        ZonedDateTime now = LocalDateTime.now(clock).atZone(ZoneId.of(timeZone));
        return formatter.format(now);
    }
}
