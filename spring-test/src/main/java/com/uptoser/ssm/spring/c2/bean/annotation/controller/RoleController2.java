package com.uptoser.ssm.spring.c2.bean.annotation.controller;

import com.uptoser.ssm.spring.c2.bean.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//这里使用了注解@Scope，并且声明为原型
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RoleController2 {

    private final RoleService roleService;

    /**
     * 通过构造器注入
     */
    @Autowired
    public RoleController2(@Qualifier("roleService3") RoleService roleService) {
        this.roleService = roleService;
    }

    public void printRole(Role role) {
        roleService.printRoleInfo(role);
    }
}
