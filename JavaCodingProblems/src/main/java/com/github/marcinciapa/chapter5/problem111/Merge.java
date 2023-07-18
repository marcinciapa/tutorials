package com.github.marcinciapa.chapter5.problem111;

import java.time.Clock;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

class Merge {

    private final Map<String, Instant> resourceWithAccessTime;
    private final Clock clock;

    Merge(Map<String, Instant> resourceWithAccessTime, Clock clock) {
        this.resourceWithAccessTime = new HashMap<>(resourceWithAccessTime);
        this.clock = clock;
    }

    String access(String resource) {
        resourceWithAccessTime.merge(resource, Instant.now(clock),
                (instant1, instant2) -> instant1.isAfter(instant2) ? instant1 : instant2
        );
        return resource;
    }

    Instant lastAccessed(String resource) {
        return resourceWithAccessTime.get(resource);
    }
}
