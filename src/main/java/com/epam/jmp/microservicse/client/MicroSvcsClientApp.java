package com.epam.jmp.microservicse.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.epam.jmp.microservicse.client.config.FoodDeliveryConfiguration;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(FoodDeliveryConfiguration.class)
@ComponentScan("com.epam.jmp.microservicse.client.controller")
public class MicroSvcsClientApp {

	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or client-app.yml
		System.setProperty("spring.config.name", "client-app");

		SpringApplication.run(MicroSvcsClientApp.class, args);
	}

}
