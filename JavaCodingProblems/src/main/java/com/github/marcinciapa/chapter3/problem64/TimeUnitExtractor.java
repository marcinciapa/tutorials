package com.github.marcinciapa.chapter3.problem64;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

interface TimeUnitExtractor {

    int get(ChronoField unit, LocalDateTime dateTime);
}
