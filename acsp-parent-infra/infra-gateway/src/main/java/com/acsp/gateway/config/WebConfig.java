package com.acsp.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {

    configurer.setUseSuffixPatternMatch(false);
    configurer.setUseTrailingSlashMatch(false);
  }

}
