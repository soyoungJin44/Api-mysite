package com.javaex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("/api/**") // 경로
	          .allowedMethods("GET", "POST", "PUT", "DELETE")
	          .allowedOrigins("http://localhost:3000", "http://localhost:9000")
	          .allowedHeaders("*") // 모든 요청해더
	          .exposedHeaders("Authorization")//노출시킬헤더
	          .allowCredentials(true); // 쿠키허용

	}
	
	//사진 첨부 경로
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		//os마다 다를때 처리
		String saveDir;
		String osName = System.getProperty("os.name").toLowerCase();
		
		if(osName.contains("linux")) {
			System.out.println("lunux");
//			saveDir = "/home/ec2-user/upload/";
			saveDir = "/app/upload/";
		}else {
			System.out.println("window");
			saveDir = "C:\\javaStudy\\upload\\";
		}
		
		
        registry.addResourceHandler("/upload/**")
        		.addResourceLocations("file:"+saveDir);

	}

}