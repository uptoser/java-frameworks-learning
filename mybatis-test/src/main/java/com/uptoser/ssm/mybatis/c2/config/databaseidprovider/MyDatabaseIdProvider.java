package com.uptoser.ssm.mybatis.c2.config.databaseidprovider;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * MyBatis也可以使用自定义数据库厂商标识的规则，只是它必须实现MyBatis提供的接口DatabaseIdProvider
 */
public class MyDatabaseIdProvider implements DatabaseIdProvider {

	private static final String DATEBASE_TYPE_DB2 = "DB2";
	private static final String DATEBASE_TYPE_MYSQL = "MySQL";
	private static final String DATEBASE_TYPE_ORACLE = "Oralce";

	private Logger log = Logger.getLogger(MyDatabaseIdProvider.class);

	/**
	 * setProperties方法可以读取配置的参数
	 */
	@Override
	public void setProperties(Properties props) {
		//mybatis配置文件中的参数
		log.info(props);
	}

	@Override
	public String getDatabaseId(DataSource dataSource) throws SQLException {
		Connection connection = dataSource.getConnection();
		String dbProductName = connection.getMetaData().getDatabaseProductName();
		if (MyDatabaseIdProvider.DATEBASE_TYPE_DB2.equals(dbProductName)) {
			return "db2";
		} else if (MyDatabaseIdProvider.DATEBASE_TYPE_MYSQL
				.equals(dbProductName)) {
			return "mysql";
		} else if (MyDatabaseIdProvider.DATEBASE_TYPE_ORACLE
				.equals(dbProductName)) {
			return "oracle";
		} else {
			return null;
		}
	}

}
