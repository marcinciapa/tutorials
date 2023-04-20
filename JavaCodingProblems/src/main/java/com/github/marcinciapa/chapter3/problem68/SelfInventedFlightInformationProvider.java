package com.github.marcinciapa.chapter3.problem68;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class SelfInventedFlightInformationProvider implements FlightInformationProvider {

    private final ZonedDateTime arrivalTime;

    SelfInventedFlightInformationProvider(
            String originTimeZone,
            String destinationTimeZone,
            LocalDateTime departureTime,
            Duration flightDuration) {

        ZonedDateTime zonedDepartureTime = departureTime.atZone(ZoneId.of(originTimeZone));
        this.arrivalTime = zonedDepartureTime.withZoneSameInstant(ZoneId.of(destinationTimeZone)).plus(flightDuration);
    }

    @Override
    public LocalDateTime arrivalTime() {
        return arrivalTime.toLocalDateTime();
    }
}
