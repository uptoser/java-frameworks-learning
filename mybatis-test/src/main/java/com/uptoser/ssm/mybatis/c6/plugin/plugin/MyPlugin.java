package com.uptoser.ssm.mybatis.c6.plugin.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.Properties;

/**
 * MyBatis 允许拦截四大对象中的任意一个对象，
 * 而通过 Plugin 源码，我们也看到了需要先注册签名才能使用插件，
 * 因此首先要确定需要拦截的对象，才能进一步确定需要配置什么样的签名，进而完成拦截的方法逻辑
 *
 * 定义插件的签名
 * 其中，@Intercepts说明它是一个拦截器。@Signature 是注册拦截器签名的地方，只有签名满足条件才能拦截，
 * type可以是四大对象中的一个，这里是StatementHandler。
 * method代表要拦截四大对象的某一种接口方法，
 * args则表示该方法的参数，要根据拦截对象的方法参数进行设置
 */
@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class MyPlugin implements Interceptor {
	private Logger log = Logger.getLogger(MyPlugin.class);
	private Properties props = null;

	/**
	 * 插件方法，它将代替StatementHandler的prepare方法
	 *
	 * @param invocation
	 *            入参
	 * @return 返回预编译后的PreparedStatement.
	 * @throws Throwable
	 *             异常.
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		// 进行绑定
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		Object object = null;
		/*
		 * 分离代理对象链(由于目标类可能被多个拦截器[插件]拦截， 从而形成多次代理，通过循环可以分离出最原始的目标类)
		 */
		while (metaStatementHandler.hasGetter("h")) {
			object = metaStatementHandler.getValue("h");
			metaStatementHandler = SystemMetaObject.forObject(object);
		}
		statementHandler = (StatementHandler) object;
		String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
		Long parameterObject = (Long) metaStatementHandler.getValue("delegate.boundSql.parameterObject");
		log.info("执行的SQL：【" + sql + "】");
		log.info("参数：【" + parameterObject + "】");
		log.info("before ......");
		// 如果当前代理的是一个非代理对象，那么它就回调用真实拦截对象的方法，
		// 如果不是，那么它会调度下个插件代理对象的invoke方法
		Object obj = invocation.proceed();
		log.info("after ......");
		return obj;
	}

	/**
	 * 生成代理对象
	 *
	 * @param target
	 *            -- 被拦截对象.
	 * @return 代理对象
	 */
	@Override
	public Object plugin(Object target) {
		// 采用系统默认的Plugin.wrap方法生成
		return Plugin.wrap(target, this);
	}

	/**
	 * 设置参数，MyBatis初始化时，就会生成插件实例，并且调用这个方法.
	 *
	 * @param props
	 *            配置参数
	 */
	@Override
	public void setProperties(Properties props) {
		this.props = props;
		log.info("dbType = " + this.props.get("dbType"));
	}
}