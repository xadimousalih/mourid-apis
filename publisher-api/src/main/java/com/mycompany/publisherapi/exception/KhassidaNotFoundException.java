package com.mycompany.publisherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class KhassidaNotFoundException extends RuntimeException {

    public KhassidaNotFoundException(String id) {
        super(String.format("Khassida with id '%s' doesn't exist", id));
    }
}
