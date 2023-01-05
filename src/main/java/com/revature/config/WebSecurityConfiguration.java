package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain fireAuthFilterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests().anyRequest().authenticated();
        http.oauth2ResourceServer().jwt();
        return http.build();
    }
}
