package com.invoice.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainClass {

	private static final Logger logger = LoggerFactory.getLogger(MainClass.class);
	public static void main(String[] args) {
		logger.info("Mainclass running");
		SpringApplication.run(MainClass.class, args);
	}

}
