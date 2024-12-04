package com.uptoser.ssm.mybatis.c2.config.datasource_factory;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 自定义数据源工厂
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