package com.uptoser.ssm.spring.c5.transactional.service;

import com.uptoser.ssm.spring.c4.db.pojo.Role;

import java.util.List;

public interface RoleService {
	
	public int insertRole(Role role);
	
	public int insertRoleList(List<Role> roleList);
	
	public int insertRoleList2(List<Role> roleList);
}
