package com.eurekademo.eurrekademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class EurrekademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurrekademoApplication.class, args);
	}

}
