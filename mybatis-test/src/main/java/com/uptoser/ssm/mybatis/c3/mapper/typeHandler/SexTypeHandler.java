package com.uptoser.ssm.mybatis.c3.mapper.typeHandler;

import com.uptoser.ssm.mybatis.c2.config.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

	Logger logger = Logger.getLogger(SexTypeHandler.class);

		@Override
	public SexEnum getNullableResult(ResultSet rs, String name) throws SQLException {
		int sex = rs.getInt(name);
		logger.info("----------------"+SexEnum.getSexByKey(sex).getName());
		return SexEnum.getSexByKey(sex);
	}

	@Override
	public SexEnum getNullableResult(ResultSet rs, int index) throws SQLException {
		int sex = rs.getInt(index);
		return SexEnum.getSexByKey(sex);
	}

	@Override
	public SexEnum getNullableResult(CallableStatement cs, int index) throws SQLException {
		int sex = cs.getInt(index);
		return SexEnum.getSexByKey(sex);
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, SexEnum sex, JdbcType jdbcType) throws SQLException {
		ps.setInt(index, sex.getKey());
	}

}
