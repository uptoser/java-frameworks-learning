package com.uptoser.ssm.mybatis.c3.mapper.mapper2;

import com.uptoser.ssm.mybatis.c3.mapper.pojo2.Role2;

import java.util.List;

public interface RoleMapper2 {
	
	public Role2 getRole(Long id);
	
	public List<Role2> findRoleByUserId(Long userId);
}
