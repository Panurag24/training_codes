package com.feignHystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class EbookstoreConsumerEurekaRibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookstoreConsumerEurekaRibbonHystrixApplication.class, args);
	}
}
