package com.uptoser.ssm.spring.c2.di.main;

import com.uptoser.ssm.spring.c2.di.pojo.UserRoleAssembly;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("classpath:com/uptoser/ssm/spring/c2/di/spring-config.xml");
		UserRoleAssembly userRoleAssembly = context.getBean(UserRoleAssembly.class);
			System.err.println(userRoleAssembly.getList().get(0).getId());
	}
	
//	public static void test2() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-props.xml");
//		DataSourceBean dsBean = context.getBean(DataSourceBean.class);
//		System.out.println(dsBean.getUrl());
//	}
	
//	public static void test3() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-props.xml");
//		RoleDataSourceService RoleService = ctx.getBean(RoleDataSourceService. class);
//		RoleDataSourceService RoleService2 =  ctx.getBean(RoleDataSourceService. class);
//		System.out.println(RoleService == RoleService2);
//	}
}
