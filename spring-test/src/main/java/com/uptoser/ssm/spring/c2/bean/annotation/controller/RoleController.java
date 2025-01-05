package com.uptoser.ssm.spring.c2.bean.annotation.controller;
import com.uptoser.ssm.spring.c2.bean.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class RoleController {

	/**
	 * 通过成员变量注入
	 */
	@Autowired
	@Qualifier("roleService3")
	private RoleService roleService;

	public void printRole(Role role) {
		roleService.printRoleInfo(role);
	}
}