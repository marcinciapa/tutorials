package com.github.marcinciapa.chapter3.problem63;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

interface InstantShifter {

    Instant after(Instant instant, Period period);

    Instant after(Instant instant, Duration duration);
}
