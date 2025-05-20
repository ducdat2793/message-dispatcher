package com.example.message_dispatcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SercurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/api/test-jmeter/**").permitAll()
				.requestMatchers("/api/**",
						"/swagger-ui.html",
						"/swagger-ui/**",
						"/v3/api-docs", 
						"/v3/api-docs/**", 
						"/v3/api-docs.yaml").authenticated()
				.anyRequest().authenticated())
		 .oauth2Login(oauth2 -> oauth2
	                .defaultSuccessUrl("/swagger-ui.html", true) // ✅ config redirect after login
	            ).csrf(AbstractHttpConfigurer::disable);
//		.oauth2Login(Customizer.withDefaults())
//				.csrf(AbstractHttpConfigurer::disable); // Disable CSRF for API

		return http.build();
	}

}
