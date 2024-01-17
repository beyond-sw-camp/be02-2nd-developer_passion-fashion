package com.example.msaProductCreate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsaProductCreateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaProductCreateApplication.class, args);
	}

}
