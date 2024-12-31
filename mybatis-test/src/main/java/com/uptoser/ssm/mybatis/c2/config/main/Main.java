package com.uptoser.ssm.mybatis.c2.config.main;

import com.uptoser.ssm.mybatis.c2.config.mapper.RoleMapper;
import com.uptoser.ssm.mybatis.c2.config.mapper.UserMapper;
import com.uptoser.ssm.mybatis.c2.config.pojo.Role;
import com.uptoser.ssm.mybatis.c2.config.pojo.User;
import com.uptoser.ssm.mybatis.c2.config.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;


public class Main {

	public static void main(String[] args) {
		testRoleMapper();
		System.out.println("--------------------------------------------------------------");
		testTypeHandler();
	}

	private static void testRoleMapper() {
		Logger log = Logger.getLogger(Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			log.info(role);
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	private static void testTypeHandler() {
		Logger log = Logger.getLogger(Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			UserMapper userMapper  = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.getUser(1L);
			log.info("sex:"+user.getSex().getName());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}