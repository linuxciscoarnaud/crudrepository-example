package com.example.crudrepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.example.crudrepository.util.LoggingInterceptor;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan("com.example.crudrepository")
@SpringBootApplication
@EntityScan(basePackages = {"com.example.crudrepository.model"})
public class CrudrepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudrepositoryApplication.class, args);
	}
	

    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
	}
}

