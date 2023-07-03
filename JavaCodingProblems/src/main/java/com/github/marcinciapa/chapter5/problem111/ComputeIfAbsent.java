package com.github.marcinciapa.chapter5.problem111;

import java.time.Clock;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

class ComputeIfAbsent {

    private final Map<String, Instant> map;
    private final Clock clock;

    ComputeIfAbsent(Map<String, Instant> map, Clock clock) {
        this.map = new HashMap<>(map);
        this.clock = clock;
    }

    Instant get(String key) {
        map.computeIfAbsent(key, (k) -> Instant.now(this.clock));
        return map.get(key);
    }
}
