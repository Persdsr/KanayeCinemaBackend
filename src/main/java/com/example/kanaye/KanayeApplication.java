package com.example.kanaye;

import com.example.kanaye.POJO.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@EnableCaching
public class KanayeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanayeApplication.class, args);
	}


	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		// Разрешенные источники (замените на адрес вашего фронтенда)
		config.addAllowedOrigin("http://localhost:3000");

		// Разрешенные методы
		config.addAllowedMethod("*");

		// Разрешенные заголовки
		config.addAllowedHeader("*");

		// Разрешение использования куки и авторизации
		config.setAllowCredentials(true);

		source.registerCorsConfiguration("/**", config); // Применить ко всем URL

		return new CorsFilter(source);
	}
}
