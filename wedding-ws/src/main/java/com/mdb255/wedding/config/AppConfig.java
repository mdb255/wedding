package com.mdb255.wedding.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mdb255.wedding.domain.service.WeddingService;
import com.mdb255.wedding.domain.service.impl.WeddingServiceImpl;
import com.mdb255.wedding.domain.util.Emailer;
import com.mdb255.wedding.domain.util.impl.LiveEmailerImpl;
import com.mdb255.wedding.domain.util.impl.LogOnlyEmailerImpl;
import com.mdb255.wedding.shared.config.env.EnvConfig;
import com.mdb255.wedding.shared.config.env.EnvDevConfig;
import com.mdb255.wedding.shared.config.env.EnvProdConfig;

@Configuration
@Import({ EnvDevConfig.class, EnvProdConfig.class })
public class AppConfig {
	
	@Autowired
	EnvConfig envConfig;

	@Bean
	public WeddingService weddingService() {
		return new WeddingServiceImpl(envConfig.getMySqlConnectionUrl(), envConfig.getMySqlConnectionPw(), envConfig.getBaseUrl());
	}
	
	@Bean
	public Emailer emailer() {
		Emailer result;
		if (envConfig.isEnableSendEmail()) {
			result = new LiveEmailerImpl();
		} else {
			result = new LogOnlyEmailerImpl();
		}
		return result;
	}
}
