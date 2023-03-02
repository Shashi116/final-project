package com.eateasy.responses;

import lombok.Data;

@Data
public class CustomError {
    private String error;

    public CustomError(String message) {
        this.error = message;
    }
}
