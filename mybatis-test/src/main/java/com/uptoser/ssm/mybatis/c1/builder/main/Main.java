package com.uptoser.ssm.mybatis.c1.builder.main;

import com.uptoser.ssm.mybatis.c1.builder.mapper.RoleMapper;
import com.uptoser.ssm.mybatis.c1.builder.pojo.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis中的常用对象有SqlSessionFactory和SqlSession
 *
 * SqlSessionFactory是MyBatis的关键对象，它是单个数据库映射关系经过编译后的内存镜像
 * SqlSessionFactory 对象的实例可以通过 SqlSessionFactoryBuilder 对象来获得
 * SqlSessionFactoryBuilder则可以从XML配置文件或一个预先定制的Configuration的实例构建出SqlSessionFactory的实例
 * 每一个MyBatis的应用程序都以一个SqlSessionFactory对象的实例为核心
 *
 * SqlSession 是 MyBatis 的关键对象，它是执行持久化操作的对象，类似于 JDBC 中的Connection
 * SqlSession 对象完全包含以数据库为背景的所有执行SQL操作的方法，它的底层封装了JDBC连接，可以用SqlSession实例来直接执行已映射的SQL语句
 * 使用完SqlSession之后关闭 Session很重要，应该确保使用finally块来关闭它
 */
public class Main {
	public static void main(String[] args) throws IOException {
		String resource = "com/uptoser/ssm/mybatis/c1/builder/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		Role role = roleMapper.getRole(1L);
		System.out.println(role);
		sqlSession.close();
	}
}