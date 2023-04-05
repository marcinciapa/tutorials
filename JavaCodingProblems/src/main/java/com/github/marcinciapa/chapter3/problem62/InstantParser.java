package com.github.marcinciapa.chapter3.problem62;

import java.time.Instant;

interface InstantParser {

    Instant toInstant(String utcInstantString);
}
