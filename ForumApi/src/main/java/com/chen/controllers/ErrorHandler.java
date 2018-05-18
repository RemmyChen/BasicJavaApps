package com.chen.controllers;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorHandler implements ControllerErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerErrorHandler.class);

    @Override
    public Object onError(Invocation invocation, Throwable throwable) throws Throwable {
        LOGGER.error("some error", throwable);

        if (throwable instanceof RuntimeException) {
            return "@runtime";
        }
        return "error";
    }

}