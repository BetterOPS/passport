package com.betterops.passport.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.nio.charset.StandardCharsets;

/**
 * Created by lqs on 2017/6/15.
 */

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// 获取应用全局上下文配置类
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// 获取web相关配置类
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// DispatcherServlet配置，拦截所有请求
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		encodingFilter.setInitParameter("encoding", StandardCharsets.UTF_8.name());
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.addMappingForUrlPatterns(null, false, "/*");
	}

}
