package com.kurly.hack.festa.hallikurly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // CORS를 적용할 URL패턴 와일드 카드
				.allowedOrigins("*") // 자원 공유 허락 , * 은 모든 자원 공유
				.allowedMethods("*"); // 허용할 메소드 * 도가능, 여러개 지정 가능
	}
}
