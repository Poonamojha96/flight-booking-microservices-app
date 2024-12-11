package com.example.api.service;

import com.example.api.model.FlightAvailabilityRequest;
import org.springframework.http.HttpStatusCode;

public interface FlightAvailabilityService {
    boolean checkFlightAvailability(FlightAvailabilityRequest flightAvailabilityRequest);
}
