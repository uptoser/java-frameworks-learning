package com.uptoser.ssm.spring.c5.transactional.main;

import com.uptoser.ssm.spring.c4.db.pojo.Role;
import com.uptoser.ssm.spring.c5.transactional.config.SpringConfig;
import com.uptoser.ssm.spring.c5.transactional.service.RoleListService;
import com.uptoser.ssm.spring.c5.transactional.service.RoleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    List<Role> roleList;
    {
        roleList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Role role = new Role();
            role.setRoleName("role_name_" + i);
            role.setNote("note_" + i);
            roleList.add(role);
        }
    }

    @Test
    public void test() {
        //测试隔离级别和传播行为 Propagation.REQUIRES_NEW 内部出现异常不会全部回滚
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        RoleListService roleListService = ctx.getBean(RoleListService.class);
        int count = roleListService.insertRoleList(roleList);
        System.out.println(count);
    }

    @Test
    public void selfCall(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        RoleService roleService = ctx.getBean(RoleService.class);
        int i = roleService.insertRoleList(roleList);
        System.out.println(i);
    }
    @Test
    public void selfCall2(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        RoleService roleService = ctx.getBean(RoleService.class);
        int i = roleService.insertRoleList2(roleList);
        System.out.println(i);
    }
}