package com.teachkal.btf.spring.mono.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;

public class OrderNotFoundException extends ResponseStatusException {

    public OrderNotFoundException(final long id) {
        super(HttpStatus.NOT_FOUND,
                MessageFormat.format("Order not found with id: {0}", id)
        );
    }
}
