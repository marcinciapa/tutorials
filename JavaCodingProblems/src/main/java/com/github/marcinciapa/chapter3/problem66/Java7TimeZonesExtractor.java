package com.github.marcinciapa.chapter3.problem66;

import java.util.List;
import java.util.TimeZone;

class Java7TimeZonesExtractor implements TimeZonesExtractor {

    @Override
    public List<String> extractTimeZones() {
        String[] availableZones = TimeZone.getAvailableIDs();
        return List.of(availableZones);
    }
}
