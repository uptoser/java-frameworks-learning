package com.uptoser.ssm.spring.c3.aop.aop.main;

import com.uptoser.ssm.spring.c2.bean.xml.pojo.Role;
import com.uptoser.ssm.spring.c3.aop.aop.config.AopConfig;
import com.uptoser.ssm.spring.c3.aop.aop.service.RoleService;
import com.uptoser.ssm.spring.c3.aop.aop.verifier.RoleVerifier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AopMain {

	@Test
	public void testAnnotation() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		Role role = new Role();
		role.setId(1L);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		RoleService roleService = context.getBean(RoleService.class);
		roleService.printRole(role);
		System.out.println("---------测试带固定参数---------");
		roleService.printRole(role,1);
		System.out.println("---------测试异常---------");
		role = null;
		roleService.printRole(role);
	}
	@Test
	public void testXML() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:com/uptoser/ssm/spring/c3/aop/spring-cfg3.xml");
		Role role = new Role();
		role.setId(1L);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		RoleService roleService = context.getBean(RoleService.class);
		roleService.printRole(role);
	}

	/**
	 * 测试引入
	 *
	 * 原理：
	 * 生成动态代理对象是通过类似于下面这行代码来实现的
	 * return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this);
	 *
	 * obj.getClass（）.getInterfaces（）意味着代理对象挂在多个接口之下
	 * 只要Spring AOP让代理对象挂到RoleService和RoleVerifier两个接口之下，那么就可以把对应的Bean通过强制转换
	 *
	 * 同样的如果RoleServiceImpl没有接口，那么它也会使用CGLIB动态代理，
	 * 使用增强者类（Enhancer）也会有一个interfaces的属性，允许代理对象挂到对应的多个接口下
	 */
	@Test
	public void testIntroduction() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext (AopConfig.class);
		RoleService roleService = ctx.getBean(RoleService.class);
		RoleVerifier roleVerifier = (RoleVerifier) roleService;
		Role role = null;
		System.out.println(roleVerifier.verify(role));
		role = new Role();
		role.setId(1L);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		if (!roleVerifier.verify(role)) {
		    roleService.printRole(role);
		}
	}
}
