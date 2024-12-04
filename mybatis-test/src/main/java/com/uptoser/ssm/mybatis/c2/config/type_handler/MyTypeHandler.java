package com.uptoser.ssm.mybatis.c2.config.type_handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

/**
 * 在JDBC中，需要在PreparedStatement对象中设置那些已经预编译过的SQL语句的参数,执行SQL后，会通过ResultSet对象获取得到数据库的数据
 * typeHandler的作用就是承担jdbcType和javaType之间的相互转换
 * 在很多情况下我们并不需要去配置typeHandler、jdbcType、javaType，因为MyBatis会探测应该使用什么类型的typeHandler进行处理
 * 对于那些需要使用自定义枚举的场景，或者数据库使用特殊数据类型的场景，可以使用自定义的typeHandler去处理类型之间的转换问题
 * 在大部分的情况下无须显式地声明jdbcType和javaType，或者用typeHandler去指定对应的typeHandler来实现数据类型转换
 */
@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeHandler implements TypeHandler<String> {

	Logger logger = Logger.getLogger(MyTypeHandler.class);

	@Override	
    public void setParameter(PreparedStatement ps, int i, String parameter,
			JdbcType jdbcType) throws SQLException {
		logger.info("设置string参数【" + parameter+"】");
		ps.setString(i, parameter);
	}

	@Override	
    public String getResult(ResultSet rs, String columnName)
			throws SQLException {
		String result = rs.getString(columnName);
		logger.info("读取string参数1【" + result+"】");
		return result;
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		String result = rs.getString(columnIndex);
		logger.info("读取string参数2【" + result+"】");
		return result;
	}

	@Override
	public String getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		String result = cs.getString(columnIndex);
		logger.info("读取string参数3【" + result+"】");
		return result;
	}
}
