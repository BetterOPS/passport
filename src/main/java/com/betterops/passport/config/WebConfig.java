package com.betterops.passport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by lqs on 2017/6/15.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.betterops.passport.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// 静态资源
		configurer.enable();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/*");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}

}
