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
			try {
			  if (Object.class.equals(method.getDeclaringClass())) {
				return method.invoke(this, args);
			  }
			  return cachedInvoker(method).invoke(proxy, method, args, sqlSession);
			} catch (Throwable t) {
			  throw ExceptionUtil.unwrapThrowable(t);
			}
		}
		invoke首先判断是否是一个类，这里Mapper是一个接口不是类，所以判定失败。
		然后会生成MapperMethod对象，它是通过cachedMapperMethod方法对其初始化的。
		最后执行execute方法，把SqlSession和当前运行的参数传递进去

		Mapper的XML文件的命名空间对应的是这个接口的全限定名，而方法就是那条SQL的id，
		这样MyBatis就可以根据全路径和方法名，将其和代理对象绑定起来。
		通过动态代理技术，让这个接口运行起来，而后采用命令模式。
		最后使用SqlSession接口的方法使得它能够执行对应的 SQL。
		 */
		RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
		Role role = roleMapper.getRole(1L);
		//上面的代码相当于：
		//Role role = sqlSession.selectOne("com.uptoser.ssm.mybatis.c1.builder.mapper.RoleMapper.getRole",1L);

		/*
		显然通过类名和方法名字就可以匹配到配置的SQL。
		而实际上SqlSession的执行过程是通过Executor、StatementHandler、ParameterHandler和ResultSetHandler来完成数据库操作和结果返回的
		selectList(){
			return executor.query(ms, wrapCollection(parameter), rowBounds, handler);
		}
		●Executor代表执行器，由它调度StatementHandler、ParameterHandler、ResultSetHandler等来执行对应的SQL。
		先看看MyBatis是如何创建Executor的，这段代码在Configuration类当中
		public Executor newExecutor(Transaction transaction, ExecutorType executorType) {
			executorType = executorType == null ? defaultExecutorType : executorType;
			Executor executor;
			if (ExecutorType.BATCH == executorType) {
			  executor = new BatchExecutor(this, transaction);
			} else if (ExecutorType.REUSE == executorType) {
			  executor = new ReuseExecutor(this, transaction);
			} else {
			  executor = new SimpleExecutor(this, transaction);
			}
			if (cacheEnabled) {
			  executor = new CachingExecutor(executor);
			}
			return (Executor) interceptorChain.pluginAll(executor);
		}
		MyBatis 将根据配置类型去确定需要创建哪一种 Executor，它的缓存则用CachingExecutor进行包装Executor。
		在运用插件时，拦截Executor就有可能获取这样的一个对象了
		以 SIMPLE 执行器 SimpleExecutor 的 query 方法作为例子
		try{
			Configuration configuration = ms.getConfiguration();
			StatementHandler handler = configuration.newStatementHandler(wrapper, ms, parameter, rowBounds, resultHandler,boundSql);
			stmt = prepareStatement(handler, ms.getStatementLog());
			return handler.query(stmt, resultHandler);
		}
		显然MyBatis根据Configuration来构建StatementHandler，然后使用prepareStatement方法，对SQL编译和参数进行初始化
		private Statement prepareStatement(StatementHandler handler, Log statementLog) throws SQLException {
			Statement stmt;
			Connection connection = getConnection(statementLog);
			stmt = handler.prepare(connection, transaction.getTimeout());
			handler.parameterize(stmt);
			return stmt;
		}
		实现过程：它调用了StatementHandler的prepare（）进行了预编译和基础的设置，
		然后通过 StatementHandler 的 parameterize（）来设置参数，
		最后使用StatementHandler的query方法，把ResultHandler传递进去，
		使用它组织结果返回给调用者来完成一次查询，这样焦点又转移到了StatementHandler对象上

		●StatementHandler的作用是使用数据库的Statement（PreparedStatement）执行操作，它是四大对象的核心，起到承上启下的作用
		通过源码可知创建的真实对象是一个 RoutingStatementHandler 的对象，它实现了接口StatementHandler。和Executor一样，用代理对象做一层层封装。
		RoutingStatementHandler 不是真实的服务对象，它是通过适配模式来找到对应的StatementHandler来执行的。
		在MyBatis中，与Executor一样，RoutingStatementHandler分为3种：
		SimpleStatementHandler、PreparedStatementHandler、CallableStatementHandler。
		它所对应的是JDBC的Statement、PreparedStatement（预编译处理）和CallableStatement（存储过程处理）

		以最常用的PreparedStatementHandler为例，看看MyBatis是怎么执行查询的
		Executor执行查询时会执行 StatementHandler 的 prepare、parameterize 和 query 方法
		1. 执行prepare方法：
		instantiateStatement（）方法是对SQL进行了预编译，然后做一些基础配置，比如超时、获取的最大行数等的设置。
		2. Executor中会调用 parameterize（）方法去设置参数：
		public void parameterize(Statement statement) throws SQLException {
			parameterHandler.setParameters((PreparedStatement) statement);
		}
		显然这个时候它是调用 ParameterHandler 去完成的
		3. 执行query方法
		return resultSetHandler.handleResultSets(ps);

		总结一条查询SQL的执行过程：
		Executor先调用StatementHandler的prepare（）方法预编译SQL，同时设置一些基本运行的参数。
		然后用 parameterize（）方法启用 ParameterHandler 设置参数，完成预编译，执行查询，update（）也是这样的。
		如果是查询，MyBatis 会使用ResultSetHandler封装结果返回给调用者。

		●ParameterHandler是用来处理SQL参数的。
		ParameterHandler接口有两个方法:
		getParameterObject（）方法的作用是返回参数对象。
		setParameters（）方法的作用是设置预编译SQL语句的参数。

		MyBatis为ParameterHandler提供了一个实现类DefaultParameterHandler
		DefaultParameterHandler中setParameters的实现
		它还是从parameterObject对象中取到参数，然后使用typeHandler转换参数，
		如果有设置，那么它会根据签名注册的typeHandler对参数进行处理。
		而typeHandler也是在MyBatis初始化时，注册在 Configuration 里面的，需要时就可以直接拿来用了，
		MyBatis 就是通过这样完成参数设置的

		●ResultSetHandler是进行数据集（ResultSet）的封装返回处理的
		其中，handleOutputParameters（）方法是处理存储过程输出参数的。
		handleResultSets（）方法，它是包装结果集的。
		MyBatis 提供了一个DefaultResultSetHandler的实现类，在默认情况下都是通过这个类进行处理的
		实现有些复杂，因为它涉及使用JAVASSIST（或者CGLIB）作为延迟加载，
		然后通过typeHandler和ObjectFactory 进行组装结果再返回

		SqlSession内部运行总结
		SqlSession是通过执行器Executor调度StatementHandler来运行的。而StatementHandler经过3步：
		●prepared预编译SQL。
		●parameterize设置参数。
		●query/update 执行SQL。
		其中，parameterize是调用parameterHandler的方法设置的，而参数是根据类型处理器typeHandler处理的。
		query/update方法通过ResultSetHandler进行处理结果的封装，
		如果是update 语句，就返回整数，否则就通过 typeHandler 处理结果类型，
		然后用 ObjectFactory提供的规则组装对象，返回给调用者
		*/

		//关闭sqlSession
		sqlSession.close();
	}


}