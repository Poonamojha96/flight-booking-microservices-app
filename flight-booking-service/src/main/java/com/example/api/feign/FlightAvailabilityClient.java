package com.example.api.feign;

import com.example.api.FeignConfig;
import com.example.api.model.request.FlightAvailabilityRequest;
import feign.Headers;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "flight-availability-service", url = "${microservice.flight-availability-service.endpoints.endpoint.uri}", configuration = FeignConfig.class)
public interface FlightAvailabilityClient {

    @CircuitBreaker(name = "checkAvailability" ,fallbackMethod = "checkAvailabilityFallback")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json",consumes = "application/json")
    public ResponseEntity<Boolean> checkAvailability(
            @RequestParam("flightId") int flightId,
            @RequestParam("flightTo") String flightTo,
            @RequestParam("flightFrom") String flightFrom,
            @RequestParam("date") String date);

    default ResponseEntity<Boolean> checkAvailabilityFallback(Exception e){
        return new ResponseEntity<>(false,HttpStatus.OK);
    }
}
