package com.betterops.passport.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;

/**
 * Created by lqs on 2017/6/15.
 */

@Configuration
@ComponentScan(basePackages = "com.betterops.passport",
	excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
	@Resource
	private Environment environment;

}
