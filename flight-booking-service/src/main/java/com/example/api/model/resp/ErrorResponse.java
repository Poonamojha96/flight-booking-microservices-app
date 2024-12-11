package com.example.api.model.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse(int httpStatusCode, String message)
    {
        super();
        this.statusCode =httpStatusCode;
        this.message = message;
    }
}