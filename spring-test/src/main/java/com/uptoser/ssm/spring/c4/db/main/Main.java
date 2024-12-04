package com.uptoser.ssm.spring.c4.db.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.uptoser.ssm.spring.c4.db.mapper.RoleMapper;
import com.uptoser.ssm.spring.c4.db.pojo.Role;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		testSqlSessionTemplate();
		testRoleMapper();
	}

	public static void testSqlSessionTemplate() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
		SqlSessionTemplate sqlSessionTemplate = ctx.getBean(SqlSessionTemplate.class);
		Role role = new Role();
		role.setRoleName("role_name_sqlSessionTemplate");
		role.setNote("note_sqlSessionTemplate");
		sqlSessionTemplate.insert("com.uptoser.ssm.spring.c4.db.mapper.RoleMapper.insertRole", role);
		Long id = role.getId();
		Role o = sqlSessionTemplate.selectOne("com.uptoser.ssm.spring.c4.db.mapper.RoleMapper.getRole", id);
		System.out.println(o.getId());
		role.setNote("update_sqlSessionTemplate");
		sqlSessionTemplate.update("com.uptoser.ssm.spring.c4.db.mapper.RoleMapper.updateRole", role);
		sqlSessionTemplate.delete("com.uptoser.ssm.spring.c4.db.mapper.RoleMapper.deleteRole", id);
	}
	
	public static void testRoleMapper() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
		RoleMapper roleMapper = ctx.getBean(RoleMapper.class);
		Role role = roleMapper.getRole(2L);
		System.out.println(role.getRoleName());
	}
}
