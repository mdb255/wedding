package com.mdb255.wedding.shared.config.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public abstract class EnvConfig {

	@Autowired
	private Environment env;
	
	public String getMySqlConnectionUrl() {
		return env.getProperty("mySqlConnectionUrl");
	}
	
	public String getMySqlConnectionPw() {
		return env.getProperty("mySqlConnectionPw");
	}
	
	public String getBaseUrl() {
		return env.getProperty("baseUrl");
	}
	
	public boolean isEnableSendEmail() {
		return Boolean.parseBoolean(env.getProperty("enableSendEmail"));
	}
}
