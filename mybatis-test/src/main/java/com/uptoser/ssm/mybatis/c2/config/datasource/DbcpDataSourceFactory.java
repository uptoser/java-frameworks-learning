//package com.uptoser.ssm.mybatis.c2.config.datasource;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.datasource.DataSourceFactory;
//
//public class DbcpDataSourceFactory implements DataSourceFactory {
//	private Properties props = null;
//
//	@Override
//	public void setProperties(Properties props) {
//		this.props = props;
//	}
//
//	@Override
//	public DataSource getDataSource() {
//		DataSource dataSource = null;
//		try {
//			dataSource = BasicDataSourceFactory.createDataSource(props);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return dataSource;
//	}
//}