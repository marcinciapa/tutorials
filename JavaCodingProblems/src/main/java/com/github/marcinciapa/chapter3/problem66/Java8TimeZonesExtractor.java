package com.github.marcinciapa.chapter3.problem66;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Java8TimeZonesExtractor implements TimeZonesExtractor {

    @Override
    public List<String> extractTimeZones() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        return new ArrayList<>(availableZoneIds);
    }
}
