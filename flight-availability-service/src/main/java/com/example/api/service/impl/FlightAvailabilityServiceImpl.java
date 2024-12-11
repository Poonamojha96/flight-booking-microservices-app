package com.example.api.service.impl;

import com.example.api.model.FlightAvailabilityRequest;
import com.example.api.service.FlightAvailabilityService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class FlightAvailabilityServiceImpl implements FlightAvailabilityService {

    private static Logger logger= Logger.getLogger(FlightAvailabilityServiceImpl.class.getName());

    @Override
    public boolean checkFlightAvailability(FlightAvailabilityRequest flightAvailabilityRequest) {
        boolean result = Math.random()>0.5;
        logger.info("Response from check flight availability service = "+result);
        return result;
    }
}
