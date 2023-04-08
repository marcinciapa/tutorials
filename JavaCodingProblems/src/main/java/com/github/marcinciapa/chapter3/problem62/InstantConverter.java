package com.github.marcinciapa.chapter3.problem62;

import java.time.Instant;
import java.time.ZonedDateTime;

interface InstantConverter {

    ZonedDateTime toCet(Instant instant);
    Instant fromCet(ZonedDateTime cet);
}
