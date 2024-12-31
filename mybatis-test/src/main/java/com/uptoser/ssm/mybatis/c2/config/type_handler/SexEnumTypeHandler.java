package com.uptoser.ssm.mybatis.c2.config.type_handler;

import com.uptoser.ssm.mybatis.c2.config.enumeration.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MyBatis 已经定义了两个类作为枚举类型的支持，这两个类分别是：
 * ●EnumOrdinalTypeHandler。
 *   EnumOrdinalTypeHandler是按 MyBatis 根据枚举数组下标索引的方式进行匹配的，
 *   也是枚举类型的默认转换类，它要求数据库返回一个整数作为其下标，它会根据下标找到对应的枚举类型
 * ●EnumTypeHandler。
 *   EnumTypeHandler 会把使用的名称转化为对应的枚举，比如它会根据数据库返回的字符串“MALE”，
 *   进行 Enum.valueOf（SexEnum.class,"MALE"）转换
 *
 */
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

	Logger log = Logger.getLogger(SexEnumTypeHandler.class);
	@Override
	public void setParameter(PreparedStatement ps, int i, SexEnum parameter,
			JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getKey());
	}

	@Override
	public SexEnum getResult(ResultSet rs, String columnName)
			throws SQLException {
		int key = rs.getInt(columnName);
		log.info("-----------column:"+columnName);
		log.info("-----------value:"+key);
		return SexEnum.getSexByKey(key);
	}

	@Override
   public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		int key = rs.getInt(columnIndex);
		return SexEnum.getSexByKey(key);
	}

	@Override
	public SexEnum getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		int key = cs.getInt(columnIndex);
		return SexEnum.getSexByKey(key);
	}

}
