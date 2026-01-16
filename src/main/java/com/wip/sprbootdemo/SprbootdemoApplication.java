package com.wip.sprbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SprbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprbootdemoApplication.class, args);
		System.out.println("Application Started Successfully ....");
	}

}
