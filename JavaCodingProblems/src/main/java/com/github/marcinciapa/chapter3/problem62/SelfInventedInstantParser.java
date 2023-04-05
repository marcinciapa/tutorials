package com.github.marcinciapa.chapter3.problem62;

import java.time.Instant;

class SelfInventedInstantParser implements InstantParser {

    @Override
    public Instant toInstant(String utcInstantString) {
        try {
            return Instant.parse(utcInstantString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
