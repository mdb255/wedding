package com.mdb255.wedding.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mdb255.wedding.shared.config.env.EnvConfig;
import com.mdb255.wedding.shared.config.env.EnvDevConfig;
import com.mdb255.wedding.test.domain.service.impl.WeddingTestServiceImpl;

@Configuration
@Import({ EnvDevConfig.class })
public class AppConfig {
	
	@Autowired
	EnvConfig envConfig;

	@Bean
	public WeddingTestServiceImpl weddingService() {
		return new WeddingTestServiceImpl(envConfig.getMySqlConnectionUrl(), envConfig.getMySqlConnectionPw());
	}
}
