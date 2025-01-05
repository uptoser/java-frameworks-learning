package com.uptoser.ssm.spring.c2.bean.annotation.config;

import com.uptoser.ssm.spring.c2.bean.annotation.condition.DataSourceCondition;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 Spring提供了注解@PropertySource来加载属性文件
 ●name：字符串，配置这次属性配置的名称。
 ●value：字符串数组，可以配置多个属性文件。
 ●ignoreResourceNotFound:boolean值，默认为false，
 其含义为如果找不到对应的属性文件是否进行忽略处理，在默认的情况下找不到对应的配置文件会抛出异常。
 ●encoding：编码，默认为""。
*/
@PropertySource(value={"classpath:database-config.properties"}, ignoreResourceNotFound=true)
public class DataSourceConfig {
	@Bean(name = "dataSource")
	//使用注解@Profile来配置用于测试（test）环境
	@Profile("test")
	//在某些条件下不需要去装配 Bean，比如当没有属性文件中的database-config.properties 属性配置时，就不要去创建数据源
	@Conditional({DataSourceCondition.class})
	public DataSource getDataSource(
			@Value("${jdbc.database.driver}") String driver,
			@Value("${jdbc.database.url}") String url,
			@Value("${jdbc.database.username}") String username,
			@Value("${jdbc.database.password}") String password) {
		System.out.println("------DataSource-Test------\n");
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
}
