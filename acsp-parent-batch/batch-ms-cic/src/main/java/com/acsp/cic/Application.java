package com.acsp.cic;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;



/**
 * Created by elaguardia on 03/01/2016.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class Application {
	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(Application.class)
			.web(true)
			.run(args);
		
		
	}
}
