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
 * MyBatis为我们提供了一个默认的实现org.apache.ibatis.session.defaults.DefaultSqlSessionFactory
 * SqlSessionFactoryBuilder则可以从XML配置文件或一个预先定制的Configuration的实例构建出SqlSessionFactory的实例
 * 每一个MyBatis的应用程序都以一个SqlSessionFactory对象的实例为核心
 *
 * SqlSession 是 MyBatis 的关键对象，它是执行持久化操作的对象，类似于 JDBC 中的Connection
 * SqlSession 对象完全包含以数据库为背景的所有执行SQL操作的方法，它的底层封装了JDBC连接，可以用SqlSession实例来直接执行已映射的SQL语句
 * 使用完SqlSession之后关闭 Session很重要，应该确保使用finally块来关闭它
 * MyBatis为我们提供了一个默认的实现org.apache.ibatis.session.defaults.DefaultSqlSession
 */
public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 在SqlSessionFactory构建中，Configuration是最重要的，它的作用是：
		 * ●读入配置文件，包括基础配置的XML和映射器XML（或注解）。
		 * ●初始化一些基础配置，比如MyBatis的别名等，一些重要的类对象（比如插件、映射器、Object工厂、typeHandlers对象等）。
		 * ●提供单例，为后续创建SessionFactory服务，提供配置的参数。
		 * ●执行一些重要对象的初始化方法。
		 *
		 * Configuration是通过XMLConfigBuilder去构建的，首先它会读出所有XML配置的信息，然后把它们解析并保存在Configuration单例中。
		 * 它会做如下初始化：
		 * ●properties全局参数。
		 * ●typeAliases别名。
		 * ●Plugins插件。
		 * ●objectFactory对象工厂。
		 * ●objectWrapperFactory对象包装工厂。
		 * ●reflectionFactory反射工厂。
		 * ●settings环境设置。
		 * ●environments数据库环境。
		 * ●databaseIdProvider数据库标识。
		 * ●typeHandlers类型转换器。
		 * ●Mappers映射器。
		 */
		/*
		 * 在MyBatis中一条SQL和它相关的配置信息是由3个部分组成的，它们分别是MappedStatement、SqlSource和BoundSql。
		 * ●MappedStatement的作用是保存一个映射器节点（select|insert|delete|update）的内容。
		 * 它是一个类，包括许多我们配置的
		 * SQL、SQL 的 id、缓存信息、resultMap、parameterType、resultType、resultMap、languageDriver 等重要配置内容
		 * 它还有一个重要的属性sqlSource
		 * ●SqlSource是提供BoundSql对象的地方，它是MappedStatement的一个属性。
		 * 注意，它是一个接口，而不是一个实现类。这个接口只定义了一个接口方法——getBoundSql（parameterObject）
		 * 对它而言有这么重要的几个实现类：DynamicSqlSource、ProviderSqlSource、RawSqlSource、StaticSqlSource。
		 * 它的作用是根据上下文和参数解析生成需要的 SQL
		 * ●BoundSql是一个结果对象，也就是SqlSource通过对SQL和参数的联合解析得到的SQL和参数，
		 * 通过它便可以拿到要执行的SQL和参数，通过SQL和参数就可以来增强MyBatis底层的功能
		 *
		 * BoundSql会提供3个主要的属性：parameterMappings、parameterObject和sql。
		 *
		 * （一）、parameterObject为参数本身，可以传递简单对象、POJO或者Map、@Param注解的参数
		 * 它有一些规则
		 * ●传递简单对象，包括int、String、float、double等。
		 * 当传递int类型时，MyBatis会把参数变为Integer对象传递，类似的long、String、float、double也是如此。
		 * ●传递POJO或者Map,parameterObject就是传入的POJO或者Map。
		 * ●传递多个参数，如果没有@Param注解，那么MyBatis会把parameterObject变为一个 Map<String,Object>对象，
		 * 其键值的关系是按顺序来规划的，类似于{“1”:p1,“2”:p2,“3”:p3……,“param1”:p1,“param2”:p2,“param3”:p36……}这样的形式，
		 * 所以在编写时可以使用#{param1}或者#{1}去引用第一个参数。
		 * ●使用@Param注解，MyBatis就会把parameterObject也变为一个Map<String,Object>对象，
		 * 类似于没有@Param注解，只是把其数字的键值置换成@Param注解键值。
		 * 比如注解@Param（“key1”）String p1、@Param（“key2”）int p2、@Param（“key3”）Role p3，
		 * 那么 parameterObject 对象就是一个 Map<String,Object>，
		 * 它的键值包含{“key1”:p1,“key2”:p2,“key3”:p3,“param1”:p1,“param2”: p2,“param3”:p3}。
		 * (二)、parameterMappings是一个List，它的每一个元素都是ParameterMapping对象。
		 * 对象会描述参数，参数包括属性名称、表达式、javaType、jdbcType、typeHandler等重要信息，一般不需要去改变它。
		 * 通过它就可以实现参数和SQL的结合，以便PreparedStatement能够通过它找到parameterObject对象的属性设置参数，使得程序能准确运行。
		 * (三)、sql属性就是书写在映射器里面的一条被SqlSource解析后的SQL。
		 * 在大部分时候无须修改它，只是在使用插件时可以根据需要进行改写，改写SQL将是一件危险的事情，需要考虑周全。
		 */
		String resource = "com/uptoser/ssm/mybatis/c1/builder/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		/*
		 * 有了Configuration对象，构建SqlSessionFactory是很简单的
		 */
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*
		可以通过SqlSessionFactory的openSession()方法获取SqlSession
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*
		通过org.apache.ibatis.session.defaults.DefaultSqlSession我们看到getMapper()方法调用了configuration的方法
		public <T> T getMapper(Class<T> type) {
			return this.configuration.getMapper(type, this);
		}

		通过org.apache.ibatis.session.Configuration的getMapper()方法发现，
		它又运用了映射器的注册器MapperRegistry来获取对应的接口对象
		public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
			return this.mapperRegistry.getMapper(type, sqlSession);
		}

		在org.apache.ibatis.binding.MapperRegistry中可以看到它会启用MapperProxyFactory工厂来生成一个代理实例
		try {
			return mapperProxyFactory.newInstance(sqlSession);
		}

		向下追踪我们可以看到Mapper映射是通过动态代理来实现的
		return Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[]{this.mapperInterface} , mapperProxy)

		而代理的方法则被放到了org.apache.ibatis.binding.MapperProxy类中
		new MapperProxy(sqlSession, this.mapperInterface, this.methodCache);
		return this.newInstance(mapperProxy);

		可以看到MapperProxy类中的invoke方法逻辑
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			return Object.class.equals(method.getDeclaringClass()) ? method.invoke(this, args) : this.cachedInvoker(method).invoke(proxy, method, args, this.sqlSession);
		}

		相信大家已经知道 MyBatis 为什么只用 Mapper 接口便能够运行了，
		因为Mapper的XML文件的命名空间对应的是这个接口的全限定名，而方法就是那条SQL的id，
		这样MyBatis就可以根据全路径和方法名，将其和代理对象绑定起来。
		通过动态代理技术，让这个接口运行起来，而后采用命令模式。
		最后使用SqlSession接口的方法使得它能够执行对应的 SQL。
		 */
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		Role role = roleMapper.getRole(1L);
		System.out.println(role);
		sqlSession.close();
	}


}