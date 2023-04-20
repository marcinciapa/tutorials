package com.github.marcinciapa.chapter3.problem68;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class FlightInformationProviderTest<T extends FlightInformationProvider> {

    abstract T flightInformationProvider(String originTimeZone,
                                         String destinationTimeZone,
                                         LocalDateTime departureTime,
                                         Duration flightTime);

    @Test
    void shouldDisplayFlightArrivalTime() {
        // given
        LocalDateTime departureTime = LocalDateTime.of(2023, 4, 20, 19, 45);
        Duration flightDuration = Duration.ofHours(15).plusMinutes(30);
        LocalDateTime expectedArrivalTime = LocalDateTime.of(2023, 4, 21, 16, 15);
        T flight = flightInformationProvider("Europe/Bucharest", "Australia/Perth", departureTime, flightDuration);

        // when
        LocalDateTime arrivalTime = flight.arrivalTime();

        // then
        assertEquals(expectedArrivalTime, arrivalTime);
    }
}
