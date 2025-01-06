package com.uptoser.ssm.spring.c5.transactional.service;

import com.uptoser.ssm.spring.c4.db.pojo.Role;

import java.util.List;

public interface RoleListService {
	public int insertRoleList(List<Role> roleList);
}
