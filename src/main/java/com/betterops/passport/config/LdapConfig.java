package com.betterops.passport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import javax.annotation.Resource;

/** ldap参数配置
 *
 * 读取配置文件，并设置ldap相关参数，如url、userDN、password等
 */
@Configuration
@PropertySource("classpath:/application-dev.properties")
public class LdapConfig {
	@Resource
	Environment environment;

	@Bean
	public LdapContextSource ldapContextSource() {
		LdapContextSource contextSource = new LdapContextSource();
		contextSource.setUrl(environment.getProperty("ldap.url"));
		contextSource.setBase(environment.getProperty("ldap.base"));
		contextSource.setUserDn(environment.getProperty("ldap.username"));
		contextSource.setPassword(environment.getProperty("ldap.password"));
		return contextSource;
	}

	@Bean
	public LdapTemplate ldapTemplate() {
		return new LdapTemplate(ldapContextSource());
	}

}