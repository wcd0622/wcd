package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching // 开启spring boot基于注解的缓存管理支持
@SpringBootApplication
public class Springboot05CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot05CacheApplication.class, args);
	}

}
