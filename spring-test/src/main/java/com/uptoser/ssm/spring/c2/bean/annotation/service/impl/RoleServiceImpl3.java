package com.uptoser.ssm.spring.c2.bean.annotation.service.impl;

import com.uptoser.ssm.spring.c2.bean.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleService;
import org.springframework.stereotype.Component;

@Component("roleService3")
//@Primary
public class RoleServiceImpl3 implements RoleService {
	
	@Override
	public void printRoleInfo(Role role) {
		System.out.println("Service3");
		System.out.print("{id =" + role.getId());
		System.out.print(", roleName =" + role.getRoleName());
		System.out.println(", note =" + role.getNote() + "}");
	}
}