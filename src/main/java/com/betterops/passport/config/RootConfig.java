package com.betterops.passport.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



/**
 * Created by lqs on 2017/6/15.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.betterops.passport.controller",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}