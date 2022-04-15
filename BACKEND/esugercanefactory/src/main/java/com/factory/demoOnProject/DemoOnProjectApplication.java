package com.factory.demoOnProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication 
@ComponentScan(basePackages = {"com.factory"})
@EnableJpaRepositories("com.factory.repository")
//@EntityScan("com.factory.entity")
public class DemoOnProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOnProjectApplication.class, args);
	}
	
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2).select().build();
	}


}
