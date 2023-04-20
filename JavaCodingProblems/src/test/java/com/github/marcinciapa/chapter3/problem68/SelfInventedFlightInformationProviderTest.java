package com.github.marcinciapa.chapter3.problem68;

import java.time.Duration;
import java.time.LocalDateTime;

class SelfInventedFlightInformationProviderTest
        extends FlightInformationProviderTest<SelfInventedFlightInformationProvider> {

    @Override
    SelfInventedFlightInformationProvider flightInformationProvider(String originTimeZone,
                                                                    String destinationTimeZone,
                                                                    LocalDateTime departureTime,
                                                                    Duration flightTime) {

        return new SelfInventedFlightInformationProvider(originTimeZone, destinationTimeZone, departureTime, flightTime);
    }
}
