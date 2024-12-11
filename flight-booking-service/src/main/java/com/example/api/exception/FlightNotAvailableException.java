package com.example.api.exception;

public class FlightNotAvailableException extends RuntimeException{

    public FlightNotAvailableException(String message){
        super(message);
    }
}
