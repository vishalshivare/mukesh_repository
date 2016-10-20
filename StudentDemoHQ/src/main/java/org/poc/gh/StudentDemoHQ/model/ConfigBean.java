package org.poc.gh.StudentDemoHQ.model;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

    @Configuration
	@EnableAutoConfiguration
	@ComponentScan("org.poc.gh.StudentDemoHQ")
	public class ConfigBean {

		@Bean
		public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		    return hemf.getSessionFactory();
		}
	} 

