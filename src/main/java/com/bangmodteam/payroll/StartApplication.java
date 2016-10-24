package com.bangmodteam.payroll;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
@ComponentScan(basePackages = "com.bangmodteam.payroll")
@EnableWebMvc
public class StartApplication extends WebMvcConfigurerAdapter implements ApplicationContextAware{
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**","/app/**").addResourceLocations("/assets/","/app/");
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		// resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("myLocaleCookie");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("mylocale");
		registry.addInterceptor(interceptor);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/i18n/message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}


}
