package com.github.marcinciapa.chapter3.problem65;

import java.time.Instant;

interface InstantShifter {

    Instant addDays(int days);

    Instant minusHours(int hours);
}
