package com.mycompany.publisherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BayiteNotFoundException extends RuntimeException {

    public BayiteNotFoundException(String id) {
        super(String.format("Bayite with id '%s' doesn't exist", id));
    }
}
