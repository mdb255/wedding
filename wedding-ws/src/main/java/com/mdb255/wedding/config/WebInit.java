package com.mdb255.wedding.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.mdb255.wedding.shared.filter.SimpleCORSFilter;

// Implementations of WebApplicationInitializer are automatically detected by Spring
public class WebInit implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext containerContext) throws ServletException {
		// Configure a default profile to use if one is not otherwise set, e.g., using VMArg -Dspring.profiles.active=dev
		containerContext.setInitParameter("spring.profiles.default", "dev");
		
		configureApp(containerContext);
		configureServlet(containerContext);
		configureSecurity();
	}
	
	private void configureApp(ServletContext containerContext) {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();

		appContext.setDisplayName("Wedding WS");

		// Registers the settings in AppConfig with the root context
		appContext.register(AppConfig.class);

		// Creates the Spring Container shared by all Servlets and Filters
		containerContext.addListener(new ContextLoaderListener(appContext));
		
		// TODO Only allow access from required servers
		containerContext.addFilter("SimpleCORSFilter", SimpleCORSFilter.class).addMappingForUrlPatterns(null, false, "/*");
	}
	
	private void configureServlet(ServletContext containerContext) {
		// Creates the dispatcher servlet context
		AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();

		// Registers the servlet configuraton with the dispatcher servlet context
		servletContext.register(ServletConfig.class);

		// Further configures the servlet context
		ServletRegistration.Dynamic dispatcher = containerContext.addServlet("spring-mvc-dispatcher", new DispatcherServlet(servletContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");
	}
	
	private void configureSecurity() {
	}
}