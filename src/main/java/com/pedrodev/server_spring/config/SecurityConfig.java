package com.pedrodev.server_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(authz -> authz
	                .requestMatchers("/h2-console/**").permitAll()
	                .anyRequest().authenticated()
	            )
	            .httpBasic(Customizer.withDefaults()) // habilita Basic Auth
	            .csrf(csrf -> csrf.disable())
	            .headers(headers -> headers.frameOptions().disable());

	        return http.build();
	    }
}
