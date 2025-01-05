package com.uptoser.ssm.spring.c2.bean.annotation.service.impl;

import com.uptoser.ssm.spring.c2.bean.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class RoleServiceImpl implements RoleService {
	@Override
	public void printRoleInfo(Role role) {
		System.out.println("Service1");
		System.out.println("id =" + role.getId());
		System.out.println("roleName =" + role.getRoleName());
		System.out.println("note =" + role.getNote());
	}
}