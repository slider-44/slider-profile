package com.acsp.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by fsoli_000 on 12/30/2015.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class Application {


  public static void main(String[] args) throws Exception {
    
    new SpringApplicationBuilder(Application.class).run(args);
  }


}
