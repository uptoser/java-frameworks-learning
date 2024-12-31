package com.uptoser.ssm.mybatis.c2.config.datasource_factory;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 自定义数据源工厂
 * MyBatis 也支持第三方数据源，例如使用 DBCP 数据源，那么需要提供一个自定义的DataSourceFactory
 */
public class DbcpDataSourceFactory implements DataSourceFactory {
	private Properties props = null;

	@Override
	public void setProperties(Properties props) {
		this.props = props;
	}

	@Override
	public DataSource getDataSource() {
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dataSource;
	}
}