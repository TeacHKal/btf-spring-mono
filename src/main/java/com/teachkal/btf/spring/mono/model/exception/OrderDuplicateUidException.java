package com.teachkal.btf.spring.mono.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;

public class OrderDuplicateUidException extends ResponseStatusException {

    public OrderDuplicateUidException(String uid) {
        super(HttpStatus.BAD_REQUEST,
                MessageFormat.format("Order - Duplicated Uid: ", uid)
        );
    }
}
