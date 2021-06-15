package com.example.contactbook.profiletest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBeanDev implements MyBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBeanDev.class);

    @Override
    public void printMessage() {
        LOGGER.info("message from dev bean");
    }
}
