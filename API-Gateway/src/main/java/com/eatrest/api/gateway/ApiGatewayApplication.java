package com.eatrest.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	 public CorsFilter corsFilter() {
	     final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource= new UrlBasedCorsConfigurationSource();
	     final CorsConfiguration corsConfig = new CorsConfiguration();
	     corsConfig.setAllowCredentials(true);
	     corsConfig.addAllowedOrigin("*");
	     corsConfig.addAllowedHeader("*");
	     corsConfig.addAllowedMethod("OPTIONS");
	     corsConfig.addAllowedMethod("HEAD");
	     corsConfig.addAllowedMethod("GET");
	     corsConfig.addAllowedMethod("PUT");
	     corsConfig.addAllowedMethod("POST");
	     corsConfig.addAllowedMethod("DELETE");
	     corsConfig.addAllowedMethod("PATCH");
	     urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfig);
	     return new CorsFilter(urlBasedCorsConfigurationSource);
	 }
}
