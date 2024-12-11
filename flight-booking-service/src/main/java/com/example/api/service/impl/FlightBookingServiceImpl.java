package com.example.api.service.impl;

import com.example.api.exception.FlightNotAvailableException;
import com.example.api.feign.FlightAvailabilityClient;
import com.example.api.model.request.FlightAvailabilityRequest;
import com.example.api.model.request.FlightBookingRequest;
import com.example.api.model.resp.FlightBookingResp;
import com.example.api.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.logging.Logger;

@Service
@RefreshScope
public class FlightBookingServiceImpl implements FlightBookingService {

    @Autowired
    private FlightAvailabilityClient flightAvailabilityClient;

   private static Logger logger= Logger.getLogger(FlightBookingServiceImpl.class.getName());
    @Override
    public FlightBookingResp bookFlight(FlightBookingRequest flightBookingRequest) {
        //check availability in flight
        ResponseEntity<Boolean> isSeatAvailable;
        FlightAvailabilityRequest flightAvailabilityRequest = FlightAvailabilityRequest.builder()
                .flightId(flightBookingRequest.getFlightId())
                .flightFrom(flightBookingRequest.getFlightFrom())
                .flightTo(flightBookingRequest.getFlightTo())
                .date(flightBookingRequest.getDate())
                .build();
        FlightBookingResp flightBookingResp= null;
        try{
            isSeatAvailable = flightAvailabilityClient.checkAvailability(
                    flightAvailabilityRequest.getFlightId(),
                    flightBookingRequest.getFlightFrom(),
                    flightBookingRequest.getFlightTo(),
                    flightBookingRequest.getDate());
            logger.info("Response from check availability service="+isSeatAvailable.getBody());
            if(isSeatAvailable.getStatusCode().is2xxSuccessful()){
                //set booking status
                if(Boolean.TRUE.equals(isSeatAvailable.getBody())){
                    flightBookingResp = FlightBookingResp.builder()
                            .bookingStatus(true)
                            .bookingId((int) (Math.random()*1000))
                            .build();
                }else {
                    throw new FlightNotAvailableException("No flights available for given date");
                }
            }
        } catch (Exception e) {
            logger.info("FlightBookingServiceImpl failing with exception = "+ e);
            throw new RuntimeException(e);
        }
        return flightBookingResp;
    }
}
