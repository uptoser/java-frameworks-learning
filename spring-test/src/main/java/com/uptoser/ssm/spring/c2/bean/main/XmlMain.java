package com.uptoser.ssm.spring.c2.bean.main;

import com.uptoser.ssm.spring.c2.bean.xml.pojo.ComplexAssembly;
import com.uptoser.ssm.spring.c2.bean.xml.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.xml.pojo.UserRoleAssembly;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

	public static void main(String[] args) {
		System.out.println("------------------依赖注入-------------------");
		ApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:com/uptoser/ssm/spring/c2/bean/spring-config.xml");
		Role role1 = context.getBean("role1", Role.class);
		System.out.println(role1+"\n");
		ComplexAssembly complexAssembly = context.getBean(ComplexAssembly.class);
		complexAssembly.getList().forEach(System.out::println);
		System.out.println("");
		UserRoleAssembly userRoleAssembly = context.getBean(UserRoleAssembly.class);
		userRoleAssembly.getList().forEach(System.out::println);

		System.out.println("------------------使用XML命名空间-------------------");
		context = new ClassPathXmlApplicationContext("classpath:com/uptoser/ssm/spring/c2/bean/spring-namespace.xml");
		userRoleAssembly = context.getBean(UserRoleAssembly.class);
		userRoleAssembly.getSet().forEach(System.out::println);
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
