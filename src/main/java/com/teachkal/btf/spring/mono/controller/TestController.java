package com.teachkal.btf.spring.mono.controller;

import com.teachkal.btf.spring.mono.auth.jwt.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    private final JwtConfig jwtConfig;

    @Autowired
    public TestController(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @GetMapping
    public String testGet() {

        return jwtConfig.getSecretKey();
    }

    @PostMapping
    public String testPost() {

        return "token? ^^";
    }

}
