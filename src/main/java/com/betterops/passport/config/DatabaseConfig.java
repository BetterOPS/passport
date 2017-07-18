package com.betterops.passport.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
@MapperScan("com.betterops.passport.mapper")
public class DatabaseConfig {

    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test",
                "root", "");
        return dataSource;
    }

    @Bean
    @Profile("prod")
    public DataSource prodDataSource() {
        return null;
    }

    @Bean
    @Profile("dev")
    public SqlSessionFactoryBean devSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(devDataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.betterops.passport.domain");
        return sqlSessionFactoryBean;
    }

    @Bean
    @Profile("prod")
    public SqlSessionFactoryBean prodSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(prodDataSource());
        return sqlSessionFactoryBean;
    }
}
