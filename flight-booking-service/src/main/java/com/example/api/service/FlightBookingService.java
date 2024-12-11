package com.example.api.service;

import com.example.api.model.request.FlightBookingRequest;
import com.example.api.model.resp.FlightBookingResp;

public interface FlightBookingService {

    FlightBookingResp bookFlight(FlightBookingRequest flightBookingRequest);
}
