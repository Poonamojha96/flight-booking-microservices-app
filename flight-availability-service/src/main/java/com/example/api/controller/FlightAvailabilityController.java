package com.example.api.controller;

import com.example.api.model.FlightAvailabilityRequest;
import com.example.api.service.FlightAvailabilityService;
import com.example.api.service.impl.FlightAvailabilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/availability")
public class FlightAvailabilityController {

    @Autowired
    FlightAvailabilityService flightAvailabilityService;

    private static Logger logger= Logger.getLogger(FlightAvailabilityServiceImpl.class.getName());


    @GetMapping("/check")
    public ResponseEntity<Boolean> checkAvailability(
            @RequestParam int flightId,
            @RequestParam String flightFrom,
            @RequestParam String flightTo,
            @RequestParam String date){
        FlightAvailabilityRequest flightAvailabilityRequest= FlightAvailabilityRequest.builder()
                .flightId(flightId)
                .flightFrom(flightFrom)
                .flightTo(flightTo)
                .date(date)
                .build();
        logger.info("FlightAvailabilityController with input request= "+flightAvailabilityRequest);

        return new ResponseEntity<>(
                flightAvailabilityService.checkFlightAvailability(flightAvailabilityRequest)
                ,HttpStatusCode.valueOf(200));
    }
}
