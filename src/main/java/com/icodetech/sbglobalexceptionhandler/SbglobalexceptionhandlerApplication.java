package com.icodetech.sbglobalexceptionhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.icodetech.sbglobalexceptionhandler.*")
public class SbglobalexceptionhandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbglobalexceptionhandlerApplication.class, args);
	}

}
