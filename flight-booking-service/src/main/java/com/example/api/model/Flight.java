package com.example.api.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    private int flightId;
    private String date;
    private boolean isSeatAvailable;
    private String flightFrom;
    private String flightTo;

}
