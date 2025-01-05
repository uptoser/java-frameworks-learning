package com.uptoser.ssm.spring.c2.bean.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 条件化装配Bean
 * Spring提供了注解@Conditional去配置，通过它可以配置一个或者多个类，
 * 只是这些类都需要实现接口Condition（org.springframework.context.annotation.Condition）
 */
public class DataSourceCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//获取上下文环境
		Environment env = context.getEnvironment();
		//判断是否存在关于数据源的基础配置
		return env.containsProperty("jdbc.database.driver")
				&& env.containsProperty("jdbc.database.url")
				&& env.containsProperty("jdbc.database.username")
				&& env.containsProperty("jdbc.database.password");
	}
}
