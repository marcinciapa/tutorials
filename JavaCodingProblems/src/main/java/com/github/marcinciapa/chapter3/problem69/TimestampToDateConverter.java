package com.github.marcinciapa.chapter3.problem69;

import java.util.Date;

class TimestampToDateConverter implements TimestampToTimeConverter<Date> {

    @Override
    public Date convert(long timestamp) {
        return new Date(timestamp);
    }
}
