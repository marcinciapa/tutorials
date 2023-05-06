package com.github.marcinciapa.chapter3.problem75;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

interface StartOfDateExtractor {

    LocalDateTime toStartOfDayUTC(LocalDate date, ZoneId zone);
}
