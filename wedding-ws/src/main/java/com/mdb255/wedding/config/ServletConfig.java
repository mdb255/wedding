package com.mdb255.wedding.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.mdb255.wedding.controller", "com.mdb255.wedding.shared.filter" })
public class ServletConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
		jacksonConverter.setObjectMapper(new ObjectMapper());
        converters.add(jacksonConverter);
    }
	
	// Allows serving of standard web content, e.g., .html, .jsp
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	// If interceptors are needed
//		@Override
//	    public void addInterceptors(InterceptorRegistry registry){
//	    }
}
