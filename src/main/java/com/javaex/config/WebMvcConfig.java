package com.javaex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("/api/**") // 경로
	          .allowedMethods("GET", "POST", "PUT", "DELETE")
	          .allowedOrigins("http://localhost:3000")
	          .allowedHeaders("*") // 모든 요청해더
	          .exposedHeaders("Authorization")//노출시킬헤더
	          .allowCredentials(true); // 쿠키허용

	}

}