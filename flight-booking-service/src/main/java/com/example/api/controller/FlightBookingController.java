package com.example.api.controller;

import com.example.api.exception.FlightNotAvailableException;
import com.example.api.model.request.FlightBookingRequest;
import com.example.api.model.resp.FlightBookingResp;
import com.example.api.service.FlightBookingService;
import com.example.api.service.impl.FlightBookingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/flight")
public class FlightBookingController {

    @Autowired
    private FlightBookingService flightBookingService;

    private static Logger logger= Logger.getLogger(FlightBookingServiceImpl.class.getName());

    @PostMapping("/reserve")
    public ResponseEntity<FlightBookingResp> bookFlight(@RequestBody FlightBookingRequest flightBookingRequest){
        logger.info("FlightBookingController with input request = "+ flightBookingRequest);
        //input validations
        if(0==flightBookingRequest.getFlightId()){
            throw new FlightNotAvailableException("Flight Number not mentioned");
        }
        return new ResponseEntity<>(flightBookingService.bookFlight(flightBookingRequest), HttpStatusCode.valueOf(200));

    }

}
