package com.illuminati.ebs.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {
    private int code;
    private String message;
    private HttpStatus status; // Agregar un campo HttpStatus

    public ErrorResponse(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
