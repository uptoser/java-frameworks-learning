package com.uptoser.ssm.spring.c2.di.annotation.controller;

import com.uptoser.ssm.spring.c2.di.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.di.annotation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RoleController2 {

	private RoleService roleService = null;
	@Autowired
	public RoleController2(@Qualifier("roleService3") RoleService roleService) {
	    this.roleService = roleService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService( RoleService roleService) {
		this.roleService = roleService;
	}
	
	public void printRole(Role role) {
		roleService.printRoleInfo(role);
	}
}
