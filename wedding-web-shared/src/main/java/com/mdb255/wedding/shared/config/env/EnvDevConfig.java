package com.mdb255.wedding.shared.config.env;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
@PropertySource("classpath:web-dev.properties")
public class EnvDevConfig extends EnvConfig {
}