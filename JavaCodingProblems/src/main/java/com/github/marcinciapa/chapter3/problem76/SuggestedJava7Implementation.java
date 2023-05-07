package com.github.marcinciapa.chapter3.problem76;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class SuggestedJava7Implementation implements TimeDifferenceCalculator {

    private final Calendar time1;
    private final Calendar time2;

    public SuggestedJava7Implementation(Date time1, Date time2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(time1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(time2);
        this.time1 = calendar1;
        this.time2 = calendar2;
    }

    @Override
    public long secondsBetween() {
        long diffInMillis = time2.getTimeInMillis() - time1.getTimeInMillis();
        return TimeUnit.SECONDS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }
}
