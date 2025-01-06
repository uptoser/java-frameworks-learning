package com.uptoser.ssm.spring.c3.aop.game.service.impl;


import com.uptoser.ssm.spring.c2.bean.xml.pojo.Role;
import com.uptoser.ssm.spring.c3.aop.game.service.RoleService;

public class RoleServiceImpl implements RoleService {
	@Override
	public void printRole(Role role) {
		System.out.println(
				"{id =" + role.getId() + ", roleName=" + role.getRoleName() + ", note=" + role.getNote() + "}");
	}
}