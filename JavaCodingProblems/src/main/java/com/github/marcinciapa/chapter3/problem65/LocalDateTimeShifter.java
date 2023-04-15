package com.github.marcinciapa.chapter3.problem65;

import java.time.LocalDateTime;

interface LocalDateTimeShifter {

    LocalDateTime addDays(int days);

    LocalDateTime subtractHours(int hours);
}
