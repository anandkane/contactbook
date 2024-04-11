package com.example.contactbook;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "spring")
@AllArgsConstructor
@Setter
@Getter
public class MapProperties {
    Map<String, String> application;
    Map<String, String> servlet;
    Map<String, String> datasource;

    @Configuration
    @ConfigurationProperties(prefix = "spring.updatable.datasource")
    @AllArgsConstructor
    @Setter
    @Getter
    class Updatable {
        Map<String, String> hikari;

        @Bean
        Properties hikariDataSource() {
            Properties properties = new Properties();
            properties.putAll(hikari);
//            return new HikariDataSource(new HikariConfig(properties));
            return properties;
        }
    }

    @Bean
    DataSource somethingelse(@Qualifier("hikariDataSource") Properties properties) {
        DataSource dataSource = DataSourceBuilder.create().build();
        return dataSource;
    }

    @PostConstruct
    public void test() {
        System.out.println(application.values());
        System.out.println(servlet.values());
        System.out.println(datasource.values());
    }
}