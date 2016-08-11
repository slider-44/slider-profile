package com.acsp.email.logservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableDiscoveryClient
public class Application {
	
	public static void main(String[] args) {
		
		new SpringApplicationBuilder(Application.class).run(args);
		
	}

}
