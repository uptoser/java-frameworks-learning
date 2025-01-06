package com.uptoser.ssm.spring.c5.transactional.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.uptoser.ssm.spring.c5")
@PropertySource(value={"classpath:database-config.properties"})
@Import({MybatisConfig.class})
@EnableTransactionManagement  //开启事务
public class SpringConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource(
            @Value("${jdbc.database.driver}") String driver,
            @Value("${jdbc.database.url}") String url,
            @Value("${jdbc.database.username}") String username,
            @Value("${jdbc.database.password}") String password) {

        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    //事务管理器
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Autowired DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
