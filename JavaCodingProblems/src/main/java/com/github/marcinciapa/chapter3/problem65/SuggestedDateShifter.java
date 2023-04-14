package com.github.marcinciapa.chapter3.problem65;

import java.util.Calendar;
import java.util.Date;

class SuggestedDateShifter implements DateShifter {

    private final Date initialDate;

    SuggestedDateShifter(Date initialDate) {
        this.initialDate = initialDate;
    }

    @Override
    public Date plusDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialDate);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    @Override
    public Date minusHours(int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialDate);
        calendar.add(Calendar.HOUR_OF_DAY, -hours);
        return calendar.getTime();
    }
}
