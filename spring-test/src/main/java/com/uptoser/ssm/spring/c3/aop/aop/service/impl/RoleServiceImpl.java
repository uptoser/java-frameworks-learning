package com.uptoser.ssm.spring.c3.aop.aop.service.impl;

import com.uptoser.ssm.spring.c2.bean.xml.pojo.Role;
import com.uptoser.ssm.spring.c3.aop.aop.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {
	
	@Override
	public void printRole(Role role) {
		System.out.println("结果返回：{id: " + role.getId() + ", "
	        + "role_name : " + role.getRoleName() + ", "
	        + "note : " + role.getNote() + "}");
	}
	
	@Override
	public void printRole(Role role, int sort) {
		System.out.println("{id: " + role.getId() + ", " 
	        + "role_name : " + role.getRoleName() + ", "
	        + "note : " + role.getNote() + "}");
		System.out.println(sort);
	}
}
