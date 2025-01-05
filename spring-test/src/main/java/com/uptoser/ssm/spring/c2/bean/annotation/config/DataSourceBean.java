package com.uptoser.ssm.spring.c2.bean.annotation.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 使用引入属性文件的配置
 * 这里可以使用注解@Value和占位符
 */
@Component
public class DataSourceBean {
	@Value("${jdbc.database.driver}")
	private String driver = null;
	@Value("${jdbc.database.url}")
	private String url = null;
	@Value("${jdbc.database.username}")
	private String username = null;
	@Value("${jdbc.database.password}")
	private String password = null;

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
        System.out.println("-------DataSource-Default------\n");
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

    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}