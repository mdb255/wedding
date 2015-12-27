package com.mdb255.wedding.shared.config.env;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("test1")
@PropertySource("classpath:web-test1.properties")
public class EnvTest1Config extends EnvConfig {
}