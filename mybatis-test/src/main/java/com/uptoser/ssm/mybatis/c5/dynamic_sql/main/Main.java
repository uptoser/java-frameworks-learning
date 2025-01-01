package com.uptoser.ssm.mybatis.c5.dynamic_sql.main;

import com.uptoser.ssm.mybatis.c5.dynamic_sql.mapper.RoleMapper;
import com.uptoser.ssm.mybatis.c5.dynamic_sql.pojo.Role;
import com.uptoser.ssm.mybatis.c5.dynamic_sql.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class Main {

	@Test
	public void testFindRole1() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roleList = roleMapper.findRole1("role_name_1");
			for (Role role : roleList) {
				System.out.println(role);
			}

		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	@Test
	public void testFindRole2() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setRoleNo("role_no_1");
			role.setRoleName("role_name");
			List<Role> roleList = roleMapper.findRole2(role);
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	@Test
	public void testFindRole3() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setRoleNo("role_no_1");
			role.setRoleName("role_name");
			List<Role> roleList = roleMapper.findRole3(role);
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	@Test
	public void testFindRole4() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roleList = roleMapper.findRole4("role_name");
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	@Test
	public void testFindRole5() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roleList = roleMapper.findRole5("role_name");
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	@Test
	public void testFindRole6() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roleList = roleMapper.findRole6("role_name", "note");
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	@Test
	public void testUpdateRole() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = new Role();
			role.setNote("note_1_update");
			role.setRoleName("role_name_1_update");
			role.setRoleNo("role_no_1");
			int result = roleMapper.updateRole(role);
			System.out.println(result);
			sqlSession.commit();
		} catch(Exception ex) {
			sqlSession.rollback();
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	@Test
	public void testFindRoleByNums() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<String> roleNoList = new ArrayList<String>();
			roleNoList.add("role_no_1");
			roleNoList.add("role_no_2");
			roleNoList.add("role_no_3");
			List<Role> roleList = roleMapper.findRoleByNums(roleNoList);
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	@Test
	public void testGetRoleTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<Role> roleList = roleMapper.getRoleTest("Y");
			System.out.println(roleList.size());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}