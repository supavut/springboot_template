package com.bangmodteam.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages="com.bangmodteam.payroll")
@EnableWebMvc
public class StartApplication extends SpringBootServletInitializer {   
	  public static void main(String[] args) {  
          SpringApplication.run(StartApplication.class);  
     }  
}
