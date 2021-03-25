package com.teachkal.btf.spring.mono.model.exception;

import java.text.MessageFormat;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(final long id) {
        super(MessageFormat.format("Could not find Order with id: {0}", id));
    }
}
