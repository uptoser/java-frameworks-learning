package com.uptoser.ssm.mybatis.c1.builder.main;
import com.uptoser.ssm.mybatis.c1.builder.mapper.RoleMapper;
import com.uptoser.ssm.mybatis.c1.builder.mapper.RoleMapper2;
import com.uptoser.ssm.mybatis.c1.builder.pojo.Role;
import com.uptoser.ssm.mybatis.c1.builder.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;


public class Main {

	public static void main(String[] args) {
		testRoleMapper();
		testRoleMapper2();
		
	}
	
	
	private static void testRoleMapper() {
		Logger log = Logger.getLogger(Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			log.info(role.getRoleName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	private static void testRoleMapper2() {
		Logger log = Logger.getLogger(Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
			Role role = roleMapper2.getRole(1L);
			log.info(role.getRoleName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
}