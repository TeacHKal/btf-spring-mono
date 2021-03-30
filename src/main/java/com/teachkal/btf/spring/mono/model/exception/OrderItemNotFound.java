package com.teachkal.btf.spring.mono.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;

public class OrderItemNotFound extends ResponseStatusException {

    public OrderItemNotFound(final long id) {
        super(HttpStatus.NOT_FOUND,
                MessageFormat.format("OrderItem not found with id: {0}", id)
        );
    }
}
