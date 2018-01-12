package com.redhat.healthcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthCheckTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCheckTestApplication.class, args);
	}
}
