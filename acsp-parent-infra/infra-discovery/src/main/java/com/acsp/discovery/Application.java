package com.acsp.discovery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application {

  /**
   * Run this Spring Boot application.
   * @param args  arguments that can be processed by this application.
   */
  public static void main(String[] args) {

    new SpringApplicationBuilder(Application.class).web(true)
                                                   .run(args);
  }
}
