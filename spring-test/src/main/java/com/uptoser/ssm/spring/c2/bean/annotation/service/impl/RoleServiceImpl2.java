package com.uptoser.ssm.spring.c2.bean.annotation.service.impl;

import com.uptoser.ssm.spring.c2.bean.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("roleService2")
public class RoleServiceImpl2 implements RoleService2 {

	//在默认的情况下寻找失败它就会抛出异常，有时候我们会觉得这是可有可无的，这个时候可以通过@Autowired的配置项required来改变它，比如@Autowired（required=false）。
	@Autowired
	private Role role = null;

	public Role getRole() {
		return role;
	}

//	@Autowired
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public void printRoleInfo() {
		System.out.println("id =" + role.getId());
		System.out.println("roleName =" + role.getRoleName());
		System.out.println("note =" + role.getNote());
	}
}