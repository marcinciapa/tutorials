package com.github.marcinciapa.chapter3.problem65;

import java.util.Date;

class SelfInventedDateShifter implements DateShifter {

    private final Date initialDate;

    SelfInventedDateShifter(Date initialDate) {
        this.initialDate = initialDate;
    }

    @Override
    public Date plusDays(int days) {
        long epochMillis = initialDate.getTime();
        epochMillis += (long) days * 24 * 60 * 60 * 1000;
        return new Date(epochMillis);
    }

    @Override
    public Date minusHours(int hours) {
        long epochMillis = initialDate.getTime();
        epochMillis -= (long) hours * 60 * 60 * 1000;
        return new Date(epochMillis);
    }
}
