package com.uptoser.ssm.mybatis.c3.mapper.mapper;

import com.uptoser.ssm.mybatis.c3.mapper.param.PdCountRoleParams;
import com.uptoser.ssm.mybatis.c3.mapper.param.PdFindRoleParams;

public interface PdRoleMapper {

	public void countRole(PdCountRoleParams pdCountRoleParams);
	
	public void findRole(PdFindRoleParams pdFindRoleParams);
}
