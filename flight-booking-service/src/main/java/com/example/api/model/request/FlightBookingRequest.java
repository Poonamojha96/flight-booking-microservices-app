package com.example.api.model.request;

import com.example.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
    private int flightId;
    private User user;
    private String date;
    private String flightFrom;
    private String flightTo;
}
