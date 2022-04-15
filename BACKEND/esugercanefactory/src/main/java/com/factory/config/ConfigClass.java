package com.factory.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.factory.entity.Admin;
import com.factory.entity.Contractor;
import com.factory.entity.Farmer;
import com.factory.entity.HarvestingData;
import com.factory.entity.Login;

@Configuration
public class ConfigClass {

	@Autowired
	 DataSource dataSource;
	
	@Value("${hibernate.show_sql}")
	 private  String HIBERNATE_SHOW_SQL;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private  String AutoUpdate;
	
	@Bean
	public  LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		
		Properties hibernateproperties=new Properties();
		 hibernateproperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		 
		 hibernateproperties.put("hibernate.hbm2ddl.auto",AutoUpdate);
		 
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(hibernateproperties);
		sessionFactory.setAnnotatedClasses(Admin.class, Contractor.class,Farmer.class,Login.class,HarvestingData.class);
		
		return sessionFactory;
		  
	}
	
}
