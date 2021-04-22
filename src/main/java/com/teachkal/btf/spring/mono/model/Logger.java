package com.teachkal.btf.spring.mono.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {

    public static void info(String logString) {
        log.info("logger.info: {}", logString);
    }

    public static void error(String logString) {
        log.info("logger.error: {}", logString);
    }
}
