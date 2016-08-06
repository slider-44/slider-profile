package com.acsp.ui.main;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@Configuration
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableRedisHttpSession
@ComponentScan
public class Application {

	
	
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}
