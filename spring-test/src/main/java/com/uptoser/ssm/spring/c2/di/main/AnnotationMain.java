package com.uptoser.ssm.spring.c2.di.main;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.uptoser.ssm.spring.c1.ioc.pojo.JuiceMaker2;
import com.uptoser.ssm.spring.c2.di.annotation.config.ApplicationConfig;
import com.uptoser.ssm.spring.c2.di.annotation.config.AutowiredConfig;
import com.uptoser.ssm.spring.c2.di.annotation.controller.RoleController;
import com.uptoser.ssm.spring.c2.di.annotation.controller.RoleController2;
import com.uptoser.ssm.spring.c2.di.annotation.pojo.PojoConfig;
import com.uptoser.ssm.spring.c2.di.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.di.annotation.service.RoleDataSourceService;
import com.uptoser.ssm.spring.c2.di.annotation.service.RoleService;
import com.uptoser.ssm.spring.c2.di.annotation.service.RoleService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring提供了4种作用域，它会根据情况来决定是否生成新的对象。
 * ●单例（singleton）：它是默认的选项，在整个应用中，Spring 只为其生成一个 Bean的实例。
 * ●原型（prototype）：当每次注入，或者通过Spring IoC容器获取Bean时，Spring都会为它创建一个新的实例。
 * ●会话（session）：在Web应用中使用，就是在会话过程中Spring只创建一个实例。
 * ●请求（request）：在Web应用中使用的，就是在一次请求中Spring会创建一个实例，但是不同的请求会创建不同的实例。
 */
public class AnnotationMain {
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
//		juiceMaker2();
//		test5();
//		test6();
//		test7();
//		test8() ;
//		test9();
	}
	private static void test1() {
		ApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
		Role role = context.getBean(Role.class);
		System.err.println(role.getId());
	}
	private static void test2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Role role = context.getBean(Role.class);
		RoleService roleService = context.getBean("roleService3", RoleService.class);
		roleService.printRoleInfo(role);
		context.close();
	}
	private static void test3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleService2 roleService = context.getBean(RoleService2.class);
		roleService.printRoleInfo();
		context.close();
	}
	private static void test4() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
		RoleController roleController = context.getBean(RoleController.class);
		Role role = context.getBean(Role.class);
		roleController.printRole(role);
		context.close();
	}
	private static void juiceMaker2(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		JuiceMaker2 juiceMaker2 = context.getBean("juiceMaker2", JuiceMaker2.class);
		System.out.println(juiceMaker2);
		context.close();
	}
	private static void test5() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
		RoleController2 roleController = context.getBean(RoleController2.class);
		Role role = context.getBean(Role.class);
		roleController.printRole(role);
		context.close();
	}

	private static void test6() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		DataSource dataSource = context.getBean(DataSource.class);
		try {
			System.out.println(dataSource.getConnection().getMetaData().getDatabaseProductName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void test7() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		context.close();
	}


	/***
	 * 测试注解引入XML时候，注意到ApplicationConfig关于这个方法的注释，需要修改后才能测试。
	 */
	private static void test8() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDataSourceService roleDataSourceService = context.getBean(RoleDataSourceService.class);
		Role role = roleDataSourceService.getRole(1L);
		System.out.println(role.getRoleName());
		context.close();
	}

	private static void test9() {
		ApplicationContext context =
			     new AnnotationConfigApplicationContext(ApplicationConfig.class);
			String url = context.getEnvironment().getProperty("jdbc.database.url");
			System.out.println(url);
	}
}
