package com.mdb255.wedding.domain.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfigurator {
	
	private SessionFactory sessionFactory;
	
	public HibernateConfigurator(String dbUrl, String dbPw) {
		// Create the SessionFactory from hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate/hibernate.cfg.xml");
        System.out.println("Hibernate Configuration loaded");
        
        configuration.setProperty("hibernate.connection.url", dbUrl);
        configuration.setProperty("hibernate.connection.password", dbPw);
         
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate serviceRegistry created");
         
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
