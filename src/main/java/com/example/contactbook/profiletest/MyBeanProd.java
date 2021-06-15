package com.example.contactbook.profiletest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBeanProd implements MyBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBeanProd.class);

    @Override
    public void printMessage() {
        LOGGER.info("Message from prod bean");
    }
}
