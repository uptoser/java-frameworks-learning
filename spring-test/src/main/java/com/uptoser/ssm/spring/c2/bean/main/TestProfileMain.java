package com.uptoser.ssm.spring.c2.bean.main;

import com.uptoser.ssm.spring.c2.bean.annotation.config.ApplicationConfig;
import com.uptoser.ssm.spring.c2.bean.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleDataSourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@ActiveProfiles("test")
public class TestProfileMain {
    @Autowired
    RoleDataSourceService roleDataSourceService;

    @Test
    public void context(){
        Role role = roleDataSourceService.getRole(1L);
        System.out.println(role);
    }
}
