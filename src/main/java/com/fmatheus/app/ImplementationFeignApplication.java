package com.fmatheus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class ImplementationFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplementationFeignApplication.class, args);
	}

}
