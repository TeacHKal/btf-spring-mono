package com.teachkal.btf.spring.mono.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;

public class ProductNotFoundException extends ResponseStatusException {

    public ProductNotFoundException(final long id) {
        super(HttpStatus.NOT_FOUND,
                MessageFormat.format("Product not found with id: {0}", id)
        );
    }
}
