package com.example.contactbook.profiletest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Configuration
public class MyBeanDevConfiguration {

    @Autowired
    private Environment environment;

    @Bean
//    @Profile("dev")
    public MyBean myBeanDev() {
        return new MyBeanDev();
    }

    @Bean
//    @Profile("prod")
    public MyBean myBeanProd() {
        return new MyBeanProd();
    }

    @Bean
    public MyBean bean() {
        String[] activeProfiles = environment.getActiveProfiles();
        return Arrays.asList(activeProfiles).contains("dev") ? new MyBeanDev() : new MyBeanProd();
    }


}
