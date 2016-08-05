package com.acsp.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.DenyAllPermissionEvaluator;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableWebSecurity
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private static final String[] ALLOWED_URI_PATTERNS = {"/favicon.ico",
                                                        "/resources/thirdparty/**",
                                                        "/forgotpwd",
                                                        "/invalidsession",
                                                        "/generalerror/**",
                                                        "/hystrix.stream",
                                                        "/error"};

  @Autowired
  private UserDetailsService userDetailsService;


  @Bean
  public TokenBasedRememberMeServices rememberMeServices() {

    return new TokenBasedRememberMeServices("remember-me-key", userDetailsService);
  }


  @Bean
  public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
  }

  /**
   * 
   * @return Configured CommonsMultipartResolver instance.
   */
  @Bean
  public CommonsMultipartResolver filterMultipartResolver() {

    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    resolver.setDefaultEncoding("utf-8");
    return resolver;
  }

  @Bean
  public WebURLSecurity webURLSecurity() {
    
    return new WebURLSecurity();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.eraseCredentials(true).userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
    handler.setPermissionEvaluator(new DenyAllPermissionEvaluator());
    web.expressionHandler(handler);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        
        .antMatchers(ALLOWED_URI_PATTERNS).permitAll()

        .antMatchers("/ui-*/**").access("@webURLSecurity.checkURL(authentication, request)")

        .anyRequest().hasAnyAuthority("ROLE_USER")
        .and()

        .formLogin()
        .loginPage("/signin")
        .failureUrl("/signin?error")
        .loginProcessingUrl("/authenticate")
        .defaultSuccessUrl("/", true)
        .permitAll()
        .and()

        .logout()
        .deleteCookies("SESSION")
        .logoutSuccessUrl("/signin")
        .invalidateHttpSession(true)
        .and()

        .rememberMe()
        .rememberMeServices(rememberMeServices())
        .key("remember-me-key")
        .and()

        .httpBasic().disable()

        .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
        .csrf().csrfTokenRepository(csrfTokenRepository());
  }

  /*
   * $2a$10$8mUSgRPvQU/4WbV7TzgPpOpCRPXzX6qmHM7d8A0RDtOJ4z8Tck.gG newpassword123
   

  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("CMDUploader2016"));
  }
  */
  
  /**
   * 
   * @return Configured CsrfTokenRepository instance.
   */
  private CsrfTokenRepository csrfTokenRepository() {

    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
    repository.setHeaderName("X-XSRF-TOKEN");
    return repository;
  }
}
