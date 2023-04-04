package com.github.marcinciapa.chapter3.problem61;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

interface LocalDateTimeJoiner {

    LocalDateTime toLocalDateTime(LocalDate date, LocalTime time);
}
