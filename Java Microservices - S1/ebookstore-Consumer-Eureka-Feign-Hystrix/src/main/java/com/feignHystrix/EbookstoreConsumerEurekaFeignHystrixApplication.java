package com.feignHystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class EbookstoreConsumerEurekaFeignHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookstoreConsumerEurekaFeignHystrixApplication.class, args);
	}

}
