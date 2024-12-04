package com.uptoser.ssm.spring.c3.aop.aop.main;

import com.uptoser.ssm.spring.c3.aop.aop.config.AopConfig;
import com.uptoser.ssm.spring.c3.aop.aop.service.RoleService;
import com.uptoser.ssm.spring.c3.aop.aop.verifier.RoleVerifier;
import com.uptoser.ssm.spring.c3.aop.game.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AopMain {
	public static void main(String[] args) {
//		testAnnotation();
//		testXML();
//		testAopParams();
		testIntroduction();
	}
	
	private static void testAnnotation() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		Role role = new Role();
		role.setId(1L);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		RoleService roleService = context.getBean(RoleService.class);
		roleService.printRole(role);
		roleService.printRole(role,1);
		role = null;
		roleService.printRole(role);
	}
	
	private static void testXML() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-cfg3.xml");
		Role role = new Role();
		role.setId(1L);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		RoleService roleService = context.getBean(RoleService.class);
		roleService.printRole(role);
	}
	
	private static void testAopParams() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-cfg3.xml");
		Role role = new Role();
		role.setId(1L);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		RoleService roleService = context.getBean(RoleService.class);
		roleService.printRole(role, 1);
	}
	
	private static void testIntroduction() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext (AopConfig.class);
		RoleService roleService = ctx.getBean(RoleService.class);
		RoleVerifier roleVerifier = (RoleVerifier) roleService;
		Role role = new Role();
		role.setId(1L);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		if (roleVerifier.verify(role)) {
		    roleService.printRole(role);
		}
	}
}
