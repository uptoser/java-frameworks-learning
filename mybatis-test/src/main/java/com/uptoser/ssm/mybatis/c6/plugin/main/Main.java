package com.uptoser.ssm.mybatis.c6.plugin.main;

import com.uptoser.ssm.mybatis.c6.plugin.mapper.RoleMapper;
import com.uptoser.ssm.mybatis.c6.plugin.params.PageParams;
import com.uptoser.ssm.mybatis.c6.plugin.pojo.Role;
import com.uptoser.ssm.mybatis.c6.plugin.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;


public class Main {

	public static void main(String[] args) {
		testMyPlugin();
//		testPagePlugin();
	}

	private static void testMyPlugin() {
		Logger log = Logger.getLogger(Main.class);
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1L);
			log.info(role.getRoleName());
		} catch (Exception ex) {
		    ex.printStackTrace();
		    sqlSession.rollback();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	
	//测试时，请在配置文件mybatis-config.xml中注释掉插件MyPlugin
	private static void testPagePlugin() {
		Logger log = Logger.getLogger(Main.class);
		SqlSession sqlSession = null;
		try {
		    sqlSession = SqlSessionFactoryUtils.openSqlSession();
		    RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		    PageParams pageParams = new PageParams();
		    pageParams.setPageSize(10);
		    List <Role> roleList = roleMapper.findRole(pageParams, "role_name_");
		    log.info(roleList.size());
		} catch (Exception ex) {
		    ex.printStackTrace();
		    sqlSession.rollback();
		} finally {
		    if (sqlSession != null) {
		        sqlSession.close();
		    }
		}
	}

}