package com.teachkal.btf.spring.mono.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;

public class UserEmailNotFoundException extends ResponseStatusException {

    public UserEmailNotFoundException(String email) {
        super(HttpStatus.NOT_FOUND,
                MessageFormat.format("Email {0}, not found", email)
                );
    }
}
