package com.example.api.model.request;

import com.example.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightAvailabilityRequest {
    private int flightId;
    private String date;
    private String flightFrom;
    private String flightTo;
}
