package com.github.marcinciapa.chapter3.problem58;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

class SelfInventedDateTimeConverter implements DateTimeConverter {

    @Override
    public String toCetDateTime(String utcDateTime) {
        if (utcDateTime == null) {
            throw new IllegalArgumentException();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date parsed = dateFormat.parse(utcDateTime);
            ZonedDateTime utc = ZonedDateTime.ofInstant(parsed.toInstant(), ZoneId.of("UTC"));
            ZonedDateTime cet = utc.withZoneSameInstant(ZoneId.of("CET")).withLaterOffsetAtOverlap();
            return cet.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss zzz"));
        } catch (ParseException e) {
            throw new DateTimeException("");
        }

    }
}
