package com.betterops.passport.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;


@Configuration
@MapperScan("com.betterops.passport.mapper")
public class DatabaseConfig {

    @Configuration
    @Profile("dev")
    @PropertySource("classpath:application-dev.properties")
    static class Dev {}

    @Configuration
    @Profile("prod")
    @PropertySource("classpath:application-prod.properties")
    static class Prod {}

    @Value("${spring.datasource.driverClassName}") String driver;
    @Value("${spring.datasource.username}") String username;
    @Value("${spring.datasource.password}") String password;
    @Value("${spring.datasource.url}") String url;
    @Value("${spring.datasource.initialSize}") int initialSize;
    @Value("${publicKey}") String publicKey;
    @Value("${spring.datasource.minIdle}") int minIdle;
    @Value("${spring.datasource.maxActive}") int maxActive;
    @Value("${spring.datasource.maxWait}") long maxWait;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}") long timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}") long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}") String validationQuery;
    @Value("${spring.datasource.testWhileIdle}") boolean testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}") boolean testOnBorrow;
    @Value("${spring.datasource.testOnReturn}") boolean testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}") boolean poolPreparedStatements;
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}") int maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.filters}") String filters;
    @Value("${spring.datasource.connectionProperties}") String connectionProperties;


    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setConnectionProperties(connectionProperties);
        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.betterops.passport.domain");
        // PageInterceptor
        Interceptor[] interceptors = new Interceptor[1];
        interceptors[0] = pageInterceptor();
        sqlSessionFactoryBean.setPlugins(interceptors);
        return sqlSessionFactoryBean;
    }

    // PageInterceptor
    private PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");

        properties.setProperty("pageSizeZero", "false");
        properties.setProperty("reasonable", "false");
        properties.setProperty("params", "pageNum,pageSize");
        properties.setProperty("closeConn", "true");

        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
