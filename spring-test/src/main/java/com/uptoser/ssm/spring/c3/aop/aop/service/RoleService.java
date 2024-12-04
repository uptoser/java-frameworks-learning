package com.uptoser.ssm.spring.c3.aop.aop.service;

import com.uptoser.ssm.spring.c3.aop.game.pojo.Role;

public interface RoleService {
	
	public void printRole(Role role);
	
	public void printRole(Role role, int sort);
}
