package com.github.marcinciapa.chapter3.problem74;

import java.time.Clock;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.YEAR;

class Java7AgeCalculator implements AgeCalculator {

    private final Date dateOfBirth;
    private final Date now;

    Java7AgeCalculator(Instant dateOfBirth, Clock clock) {
        this.dateOfBirth = Date.from(dateOfBirth);
        this.now = Date.from(Instant.now(clock));
    }

    @Override
    public int calculateAge() {
        Calendar dateOfBirthCalendar = Calendar.getInstance();
        dateOfBirthCalendar.setTime(this.dateOfBirth);
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(now);

        if (dateOfBirthCalendar.after(nowCalendar)) {
            return 0;
        }

        int calendarYears = nowCalendar.get(YEAR) - dateOfBirthCalendar.get(YEAR);

        if (!wasBirthdayAlreadyThisYear(dateOfBirthCalendar, nowCalendar)) {
            calendarYears--;
        }

        return calendarYears;
    }

    private boolean wasBirthdayAlreadyThisYear(Calendar dateOfBirthCalendar, Calendar nowCalendar) {
        nowCalendar.set(YEAR, 2000);
        dateOfBirthCalendar.set(YEAR, 2000);
        return !dateOfBirthCalendar.after(nowCalendar);
    }
}
