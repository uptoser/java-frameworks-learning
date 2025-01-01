package com.uptoser.ssm.mybatis.c4.cascade.mapper2;

import com.uptoser.ssm.mybatis.c4.cascade.pojo2.Role2;

import java.util.List;

public interface RoleMapper2 {
	
	public Role2 getRole(Long id);
	
	public List<Role2> findRoleByUserId(Long userId);
}
