package com.mdb255.wedding.shared.config.env;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("prod")
@PropertySource("classpath:web-prod.properties")
public class EnvProdConfig extends EnvConfig {
}