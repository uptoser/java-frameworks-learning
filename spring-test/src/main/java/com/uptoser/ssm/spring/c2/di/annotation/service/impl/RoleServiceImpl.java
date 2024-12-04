package com.uptoser.ssm.spring.c2.di.annotation.service.impl;

import com.uptoser.ssm.spring.c2.di.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.di.annotation.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {
	@Override
	public void printRoleInfo(Role role) {
		System.out.println("id =" + role.getId());
		System.out.println("roleName =" + role.getRoleName());
		System.out.println("note =" + role.getNote());
	}
}