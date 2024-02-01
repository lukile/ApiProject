package com.agregio.apiproject.offer.domain.exception;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException() {
        super("Datetime null or invalid");
    }
}
