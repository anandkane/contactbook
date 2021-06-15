package com.example.contactbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableSwagger2
@ComponentScan("com.example.contactbook")
public class ContactBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactBookApplication.class, args);
	}
}
