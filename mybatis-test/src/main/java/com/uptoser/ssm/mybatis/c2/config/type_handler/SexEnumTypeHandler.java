package com.uptoser.ssm.mybatis.c2.config.type_handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uptoser.ssm.mybatis.c2.config.enumeration.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;


public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

	Logger log = Logger.getLogger(SexEnumTypeHandler.class);
	@Override
	public void setParameter(PreparedStatement ps, int i, SexEnum parameter,
			JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getId());
	}

	@Override
	public SexEnum getResult(ResultSet rs, String columnName)
			throws SQLException {
		int id = rs.getInt(columnName);
		log.info("-----------columnName:"+columnName);
		log.info("-----------id:"+id);
		return SexEnum.getSexById(id);
	}

	@Override
   public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		int id = rs.getInt(columnIndex);
		return SexEnum.getSexById(id);
	}

	@Override
	public SexEnum getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		int id = cs.getInt(columnIndex);
		return SexEnum.getSexById(id);
	}

}
