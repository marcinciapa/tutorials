package com.github.marcinciapa.chapter3.problem76;

import java.util.Date;

class SelfInventedJava7Implementation implements TimeDifferenceCalculator {

    private final Date date1;
    private final Date date2;

    public SelfInventedJava7Implementation(Date date1, Date date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    @Override
    public long secondsBetween() {

        long seconds1 = date1.getTime() / 1000;
        long seconds2 = date2.getTime() / 1000;

        return seconds2 - seconds1;
    }
}
